package com.dashboard.service.impl.account;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.constants.DashboardConstants;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.entity.account.AccountCategoryTreeVO;
import com.dashboard.mapper.account.AccountCategoryMapper;
import com.dashboard.service.account.AccountCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        AccountCategoryTreeVO rootAccountCategoryTreeVO = new AccountCategoryTreeVO();
        rootAccountCategoryTreeVO.setId(DashboardConstants.ZERO_LONG);
        rootAccountCategoryTreeVO.setName("根节点");
        accountCategoryTreeVOList.add(rootAccountCategoryTreeVO);

        Condition condition = new Condition(AccountCategory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", StatusEnum.ON.getCode());
        List<AccountCategory> accountCategoryList = accountCategoryMapper.selectByCondition(condition);

        Map<Long, AccountCategoryTreeVO> treeVOMap =
                accountCategoryList.stream()
                        .collect(
                                Collectors.toMap(AccountCategory::getId,
                                        accountCategory -> {
                                            AccountCategoryTreeVO accountCategoryTreeVO = new AccountCategoryTreeVO();
                                            accountCategoryTreeVO.setId(accountCategory.getId());
                                            accountCategoryTreeVO.setName(accountCategory.getName());
                                            accountCategoryTreeVO.setParentId(accountCategory.getParentId());
                                            accountCategoryTreeVO.setChildren(new ArrayList<>());

                                            return accountCategoryTreeVO;
                                        }));

        accountCategoryList.forEach(accountCategory -> {
            Long id = accountCategory.getId();
            Long parentId = accountCategory.getParentId();
            AccountCategoryTreeVO accountCategoryTreeVO = treeVOMap.get(id);
            if (DashboardConstants.ZERO_LONG.equals(parentId) && Objects.nonNull(accountCategoryTreeVO)) {
                // 一级分类
                accountCategoryTreeVOList.add(accountCategoryTreeVO);
            } else {
                // 子分类通过parentID获取到父分类
                AccountCategoryTreeVO parentAccountCategoryTreeVO = treeVOMap.get(parentId);
                if (Objects.nonNull(parentAccountCategoryTreeVO)) {
                    parentAccountCategoryTreeVO.getChildren().add(accountCategoryTreeVO);
                }
            }
        });

        return accountCategoryTreeVOList;
    }

    @Override
    public AccountCategory findAccountCategoryById(String id) {

        return accountCategoryMapper.selectByPrimaryKey(id);
    }
}
