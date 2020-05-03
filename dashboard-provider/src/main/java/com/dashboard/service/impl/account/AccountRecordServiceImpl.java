package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.entity.account.builder.AccountRecordBuilder;
import com.dashboard.mapper.account.AccountRecordMapper;
import com.dashboard.service.account.AccountRecordService;
import javafx.scene.shape.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author konglinghui
 * @description 消费记录服务
 * @date 2020/4/18 22:41
 **/
@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    @Override
    public void createAccountRecord(AccountRecord accountRecord) {
        accountRecordMapper.insert(accountRecord);
    }

    @Override
    public void updateAccountRecord(AccountRecord accountRecord) {
        accountRecordMapper.updateByPrimaryKey(accountRecord);
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
    public List<AccountRecord> findAccountRecordList() {
        Condition condition = new Condition(AccountRecord.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", StatusEnum.ON.getCode());

        List<AccountRecord> accountRecordList = accountRecordMapper.selectByCondition(condition);

        return accountRecordList;
    }
}
