package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.mapper.account.AccountRecordMapper;
import com.dashboard.service.account.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
