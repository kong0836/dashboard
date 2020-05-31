package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.constants.DashboardConstants;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountBudget;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.entity.account.AccountCategoryTreeVO;
import com.dashboard.entity.account.AccountCategoryVO;
import com.dashboard.entity.account.CategoryTreeVO;
import com.dashboard.entity.account.builder.AccountBudgetBuilder;
import com.dashboard.service.account.AccountBudgetService;
import com.dashboard.service.account.AccountCategoryService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author konglinghui
 * @description 消费分类
 * @date 2020/4/19 12:22
 **/
@RestController
@RequestMapping("/account/category/rest")
public class AccountCategoryRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCategoryRestController.class);

    @Reference
    private AccountCategoryService accountCategoryService;

    @Reference
    private AccountBudgetService accountBudgetService;

    /**
     * 创建消费分类
     *
     * @param accountCategory
     * @return
     */
    @PostMapping("/createCategory")
    public RestResult createCategory(@RequestBody AccountCategory accountCategory) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("创建消费分类:{}", accountCategory);
        }

        accountCategory.setId(SnowflakeIdWorker.generateId());
        accountCategory.setCreateBy("0");
        accountCategory.setUpdateBy("0");
        accountCategory.setCreateTime(DateTimeUtils.currentTimeStamp());
        accountCategory.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountCategoryService.createAccountCategory(accountCategory);

        if (!DashboardConstants.ZERO_LONG.equals(accountCategory.getParentId())) {
            // 插入默认预算数据
            AccountBudget accountBudget = this.buildAccountBudget(accountCategory);
            accountBudgetService.insertAccountBudget(accountBudget);
        }

        return RestResult.success();
    }

    /**
     * 更新消费分类
     *
     * @param accountCategory
     * @return
     */
    @PostMapping("/updateCategory")
    public RestResult updateCategory(@RequestBody AccountCategory accountCategory) {

        accountCategoryService.updateAccountCategory(accountCategory);

        return RestResult.success();
    }

    /**
     * 启用
     *
     * @param id 消费分类主键ID
     * @return
     */
    @PostMapping("/enableCategory/{id}")
    public RestResult enableCategory(@PathVariable String id) {

        AccountCategory accountCategory = accountCategoryService.findAccountCategoryById(id);
        accountCategory.setStatus(StatusEnum.ON.getCode());
        accountCategory.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountCategoryService.updateAccountCategory(accountCategory);

        return RestResult.success();
    }

    /**
     * 启用
     *
     * @param id 消费分类主键ID
     * @return
     */
    @PostMapping("/disableCategory/{id}")
    public RestResult disableCategory(@PathVariable String id) {

        AccountCategory accountCategory = accountCategoryService.findAccountCategoryById(id);
        accountCategory.setStatus(StatusEnum.OFF.getCode());
        accountCategory.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountCategoryService.updateAccountCategory(accountCategory);

        return RestResult.success();
    }

    /**
     * 查询消费分类数据
     *
     * @return
     */
    @PostMapping("/findCategoryList")
    public RestResult findCategoryList(@RequestBody AccountCategoryPageInfo accountCategoryPageInfo) {
        if (Objects.isNull(accountCategoryPageInfo)) {
            accountCategoryPageInfo = new AccountCategoryPageInfo();
        }
        if (StringUtils.isBlank(accountCategoryPageInfo.getName())) {
            accountCategoryPageInfo.setName(null);
        }

        List<AccountCategoryTreeVO> accountCategoryTreeVOList =
                accountCategoryService.findAccountCategoryList(accountCategoryPageInfo);

        return RestResult.success(accountCategoryTreeVOList);
    }

    /**
     * 查询消费分类
     *
     * @return
     */
    @GetMapping("/findCategoryById/{id}")
    public RestResult findCategoryById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        AccountCategoryVO accountCategoryVO = accountCategoryService.findAccountCategoryById(id);

        return RestResult.success(accountCategoryVO);
    }

    /**
     * 查询消费分类菜单树
     *
     * @param type 分类类型
     * @return
     */
    @GetMapping("/findCategoryTreeList/{type}")
    public RestResult findCategoryTreeList(@PathVariable Integer type) {
        if (Objects.isNull(type)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        List<CategoryTreeVO> accountCategoryTreeVOList = accountCategoryService.findAccountCategoryTreeList(type);

        return RestResult.success(accountCategoryTreeVOList);
    }

    /**
     * 组装消费预算数据
     *
     * @param accountCategory
     * @return
     */
    private AccountBudget buildAccountBudget(AccountCategory accountCategory) {
        AccountBudget accountBudget = new AccountBudgetBuilder()
                .id(SnowflakeIdWorker.generateId())
                .categoryId(accountCategory.getId())
                .status(StatusEnum.ON.getCode())
                .amount(BigDecimal.ZERO)
                .remark("")
                .createTime(accountCategory.getCreateTime())
                .createBy(accountCategory.getCreateBy())
                .updateTime(accountCategory.getCreateTime())
                .updateBy(accountCategory.getCreateBy())
                .build();

        return accountBudget;
    }
}
