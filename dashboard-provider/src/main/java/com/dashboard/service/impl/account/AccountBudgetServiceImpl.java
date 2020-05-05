package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.account.AccountBudgetMapper;
import com.dashboard.service.account.AccountBudgetService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 消费预算服务
 * @date 2020/5/5 23:00
 **/
@Service
public class AccountBudgetServiceImpl implements AccountBudgetService {

    @Autowired
    private AccountBudgetMapper accountBudgetMapper;
}
