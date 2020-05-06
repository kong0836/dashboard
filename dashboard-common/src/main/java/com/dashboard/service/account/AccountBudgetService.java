package com.dashboard.service.account;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.account.AccountBudget;
import com.dashboard.entity.account.AccountBudgetPageInfo;

import java.util.List;

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

    /**
     * 查询消费预算
     *
     * @param id
     * @return
     */
    AccountBudget findAccountBudgetById(String id);

    /**
     * 查询消费预算列表
     *
     * @param accountBudgetPageInfo
     * @return
     */
    Page<AccountBudget> findAccountBudgetList(AccountBudgetPageInfo accountBudgetPageInfo);

    /**
     * 新增消费预算数据
     *
     * @param accountBudgetList
     */
    void insertAccountBudgetByBatch(List<AccountBudget> accountBudgetList);

    /**
     * 新增消费预算数据
     *
     * @param accountBudget
     */
    void insertAccountBudget(AccountBudget accountBudget);
}
