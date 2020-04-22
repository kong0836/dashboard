package com.dashboard.service.account;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.entity.account.AccountCategoryTreeVO;

import java.util.List;

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

    /**
     * 更新
     *
     * @param accountCategory
     */
    void updateAccountCategory(AccountCategory accountCategory);

    /**
     * 查询消费分类树结构
     *
     * @return
     */
    List<AccountCategoryTreeVO> findAccountCategoryTreeList();
}
