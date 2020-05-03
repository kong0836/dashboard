package com.dashboard.service.account;

import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.entity.account.AccountCategoryTreeVO;
import com.dashboard.entity.account.CategoryTreeVO;
import com.dashboard.entity.account.AccountCategoryVO;

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
    List<AccountCategoryTreeVO> findAccountCategoryList(AccountCategoryPageInfo accountCategoryPageInfo);

    /**
     * 更新
     *
     * @param accountCategory
     */
    void updateAccountCategory(AccountCategory accountCategory);

    /**
     * 查询消费分类树结构
     *
     * @param type 分类类型
     * @return
     */
    List<CategoryTreeVO> findAccountCategoryTreeList(Integer type);

    /**
     * 查询消费分类
     *
     * @param id
     * @return
     */
    AccountCategoryVO findAccountCategoryById(String id);
}
