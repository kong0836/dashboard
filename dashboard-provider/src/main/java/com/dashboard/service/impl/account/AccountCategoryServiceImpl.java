package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.mapper.account.AccountCategoryMapper;
import com.dashboard.service.account.AccountCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 消费分类服务
 * @date 2020/4/18 22:40
 **/
@Service
public class AccountCategoryServiceImpl implements AccountCategoryService {

    @Autowired
    private AccountCategoryMapper accountCategoryMapper;

    @Override
    public void createAccountCategory(AccountCategory accountCategory) {
        accountCategoryMapper.insert(accountCategory);
    }
}
