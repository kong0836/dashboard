package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.constants.DashboardConstants;
import com.dashboard.common.entity.Page;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.entity.account.AccountCategoryTreeVO;
import com.dashboard.mapper.account.AccountCategoryMapper;
import com.dashboard.service.account.AccountCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Page<AccountCategory> findAccountCategoryList(AccountCategoryPageInfo accountCategoryPageInfo) {
        // 分页
        PageHelper.startPage(accountCategoryPageInfo);
        AccountCategory accountCategory = new AccountCategory();
        BeanUtils.copyProperties(accountCategoryPageInfo, accountCategory);

        List<AccountCategory> accountCategoryList = accountCategoryMapper.select(accountCategory);
        PageInfo<AccountCategory> pageInfo = new PageInfo(accountCategoryList);
        Page<AccountCategory> page = new Page<>();
        BeanUtils.copyProperties(pageInfo, page);

        return page;
    }

    @Override
    public void updateAccountCategory(AccountCategory accountCategory) {
        accountCategoryMapper.updateByPrimaryKey(accountCategory);
    }

    @Override
    public List<AccountCategoryTreeVO> findAccountCategoryTreeList() {
        List<AccountCategoryTreeVO> accountCategoryTreeVOList = new ArrayList<>();

        // 根节点
        AccountCategoryTreeVO accountCategoryTreeVO = new AccountCategoryTreeVO();
        accountCategoryTreeVO.setId(DashboardConstants.ZERO_LONG.toString());
        accountCategoryTreeVO.setName("根节点");
        accountCategoryTreeVOList.add(accountCategoryTreeVO);

        return accountCategoryTreeVOList;
    }

    @Override
    public AccountCategory findAccountCategoryById(String id) {

        return accountCategoryMapper.selectByPrimaryKey(id);
    }
}
