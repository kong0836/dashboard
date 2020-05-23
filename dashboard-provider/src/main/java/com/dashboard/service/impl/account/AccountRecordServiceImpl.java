package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.entity.account.AccountRecordPageInfo;
import com.dashboard.entity.account.builder.AccountRecordBuilder;
import com.dashboard.entity.analysis.AccountTotal;
import com.dashboard.entity.analysis.builder.AccountTotalBuilder;
import com.dashboard.entity.system.Person;
import com.dashboard.enums.account.AccountCategoryTypeEnum;
import com.dashboard.mapper.account.AccountRecordMapper;
import com.dashboard.mapper.analysis.AccountTotalMapper;
import com.dashboard.mapper.permission.PersonMapper;
import com.dashboard.service.account.AccountCategoryService;
import com.dashboard.service.account.AccountRecordService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author konglinghui
 * @description 消费记录服务
 * @date 2020/4/18 22:41
 **/
@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    @Autowired
    private AccountCategoryService accountCategoryService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private AccountTotalMapper accountTotalMapper;

    @Override
    public void createAccountRecord(AccountRecord accountRecord) {
        accountRecordMapper.insert(accountRecord);
    }

    @Override
    public void updateAccountRecord(AccountRecord accountRecord) {
        accountRecordMapper.updateByPrimaryKeySelective(accountRecord);
    }

    @Override
    public void deleteAccountRecord(Long id) {
        AccountRecord accountRecord = new AccountRecordBuilder()
                .id(id)
                .status(StatusEnum.OFF.getCode())
                .build();

        accountRecordMapper.updateByPrimaryKey(accountRecord);
    }

    @Override
    public Page<AccountRecord> findAccountRecordList(AccountRecordPageInfo accountRecordPageInfo) {
        PageHelper.startPage(accountRecordPageInfo);

        Condition condition = new Condition(AccountRecord.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", StatusEnum.ON.getCode());
        condition.orderBy("type").desc();
        condition.orderBy("consumerDate").desc();
        List<AccountRecord> accountRecordList = accountRecordMapper.selectByCondition(condition);

        PageInfo<AccountRecord> pageInfo = new PageInfo<>(accountRecordList);
        List<AccountRecord> accountRecords = pageInfo.getList();
        if (CollectionUtils.isEmpty(accountRecords)) {
            return new Page<>();
        }

        // 根据id查询人员信息
        List<Long> personIdList = accountRecords.stream()
                .map(AccountRecord::getPersonId)
                .collect(Collectors.toList());
        Condition personCondition = new Condition(Person.class);
        Example.Criteria personCriteria = personCondition.createCriteria();
        personCriteria.andIn("id", personIdList);
        List<Person> personList = personMapper.selectByCondition(personCondition);

        // 数据转换
        Map<Long, String> idNameMap = personList.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        Page<AccountRecord> page = new Page<>();
        BeanUtils.copyProperties(pageInfo, page);

        // 分类名称
        List<String> categoryIdList = accountRecords.stream()
                .map(accountRecord -> accountRecord.getCategoryId().toString())
                .collect(Collectors.toList());
        Condition categoryCondition = new Condition(AccountCategory.class);
        Example.Criteria categoryCriteria = categoryCondition.createCriteria();
        categoryCriteria.andIn("id", categoryIdList);
        List<AccountCategory> accountCategoryList = accountCategoryService.findAccountCategoryByIds(categoryIdList);
        Map<Long, String> idNameMaps = accountCategoryList.stream()
                .collect(Collectors.toMap(AccountCategory::getId, AccountCategory::getName));
        page.getList().forEach(accountRecord -> {
            accountRecord.setName(idNameMap.get(accountRecord.getPersonId()));
            accountRecord.setCategoryName(idNameMaps.get(accountRecord.getCategoryId()));
        });

        return page;
    }

    @Override
    public AccountRecord findAccountRecordById(String id) {
        AccountRecord accountRecord = accountRecordMapper.selectByPrimaryKey(id);

        // 上级分类
        List<String> categoryIdTem = new ArrayList<>();
        Long categoryId = accountRecord.getCategoryId();
        categoryIdTem.add(categoryId.toString());
        accountCategoryService.findCategoryByCategoryId(categoryId, categoryIdTem);
        Collections.reverse(categoryIdTem);
        accountRecord.setCategoryIdTem(categoryIdTem);

        return accountRecord;
    }

    @Override
    public void initAccountTotal(String personId) {
        List<AccountTotal> accountTotals = new ArrayList<>();

        // 根据分类ID汇总消费支出数据
        List<Map<String, Object>> accountTotalOut =
                accountRecordMapper.selectTotalByPersonId(AccountCategoryTypeEnum.OUT.getType(), personId);
        this.buildAccountTotal(personId, accountTotalOut, accountTotals);

        // 根据分类ID汇总消费收入数据
        List<Map<String, Object>> accountTotalIn =
                accountRecordMapper.selectTotalByPersonId(AccountCategoryTypeEnum.IN.getType(), personId);
        this.buildAccountTotal(personId, accountTotalIn, accountTotals);

        accountTotalMapper.insertByBatch(accountTotals);
    }

    private List<AccountTotal> buildAccountTotal(String personId,
                                                 List<Map<String, Object>> accountTotalList,
                                                 List<AccountTotal> accountTotals) {
        accountTotalList.forEach(accountTotalTem -> {
            AccountTotal accountTotal = new AccountTotalBuilder()
                    .id(SnowflakeIdWorker.generateId())
                    .consumerDate(DateTimeUtils.stringToTimestamp(accountTotalTem.get("consumerDate").toString()))
                    .amount(new BigDecimal(accountTotalTem.get("amount").toString()))
                    .createBy("0")
                    .createTime(DateTimeUtils.currentTimeStamp())
                    .personId(Long.valueOf(personId))
                    .remark("系统生成")
                    .status(StatusEnum.ON.getCode())
                    .updateBy("0")
                    .updateTime(DateTimeUtils.currentTimeStamp())
                    .build();

            accountTotals.add(accountTotal);
        });

        return accountTotals;
    }
}
