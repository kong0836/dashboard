package com.dashboard.service.account;

import com.dashboard.entity.account.AccountBudget;

/**
 * @author konglinghui
 * @description 消费预算服务
 * @date 2020/5/5 22:59
 **/
public interface AccountBudgetService {

    /**
     * 新建消费预算
     *
     * @param accountBudget
     */
    void createAccountBudget(AccountBudget accountBudget);

    /**
     * 修改消费资源
     *
     * @param accountBudget
     */
    void updateAccountBudget(AccountBudget accountBudget);

    /**
     * 删除消费预算
     *
     * @param id
     */
    void deleteAccountBudget(String id);
}
