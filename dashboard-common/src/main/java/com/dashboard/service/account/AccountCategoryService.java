package com.dashboard.service.account;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;

/**
 * @author konglinghui
 * @description 消费分类服务
 * @date 2020/4/18 22:28
 **/
public interface AccountCategoryService {

    /**
     * 新建
     *
     * @param accountCategory
     */
    void createAccountCategory(AccountCategory accountCategory);

    /**
     * 消费分类列表数据
     *
     * @param accountCategoryPageInfo
     * @return
     */
    Page<AccountCategory> findAccountCategoryList(AccountCategoryPageInfo accountCategoryPageInfo);
}
