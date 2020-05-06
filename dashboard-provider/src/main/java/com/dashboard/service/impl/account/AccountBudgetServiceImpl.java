package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.entity.account.AccountBudget;
import com.dashboard.entity.account.AccountBudgetPageInfo;
import com.dashboard.entity.account.builder.AccountBudgetBuilder;
import com.dashboard.mapper.account.AccountBudgetMapper;
import com.dashboard.mapper.account.AccountCategoryMapper;
import com.dashboard.service.account.AccountBudgetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author konglinghui
 * @description 消费预算服务
 * @date 2020/5/5 23:00
 **/
@Service
public class AccountBudgetServiceImpl implements AccountBudgetService {

    @Autowired
    private AccountCategoryMapper accountCategoryMapper;

    @Autowired
    private AccountBudgetMapper accountBudgetMapper;

    @Override
    public void createAccountBudget(AccountBudget accountBudget) {
        accountBudgetMapper.insertSelective(accountBudget);
    }

    @Override
    public void updateAccountBudget(AccountBudget accountBudget) {
        accountBudgetMapper.updateByPrimaryKeySelective(accountBudget);
    }

    @Override
    public void deleteAccountBudget(String id) {
        AccountBudget accountBudget = new AccountBudgetBuilder()
                .id(Long.valueOf(id))
                .status(StatusEnum.OFF.getCode())
                .build();

        accountBudgetMapper.updateByPrimaryKeySelective(accountBudget);
    }

    @Override
    public AccountBudget findAccountBudgetById(String id) {
        return accountBudgetMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<AccountBudget> findAccountBudgetList(AccountBudgetPageInfo accountBudgetPageInfo) {
        PageHelper.startPage(accountBudgetPageInfo);

        Condition condition = new Condition(AccountBudget.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", StatusEnum.ON.getCode());
        condition.orderBy("createTime").desc();
        List<AccountBudget> accountBudgetList = accountBudgetMapper.selectByCondition(condition);

        PageInfo<AccountBudget> pageInfo = new PageInfo<>(accountBudgetList);
        Page<AccountBudget> page = new Page<>();
        BeanUtils.copyProperties(pageInfo, page);

        return page;
    }

    @Override
    public void insertAccountBudgetByBatch(List<AccountBudget> accountBudgetList) {
        accountBudgetMapper.insertByBatch(accountBudgetList);
    }

    @Override
    public void insertAccountBudget(AccountBudget accountBudget) {
        accountBudgetMapper.insertSelective(accountBudget);
    }
}
