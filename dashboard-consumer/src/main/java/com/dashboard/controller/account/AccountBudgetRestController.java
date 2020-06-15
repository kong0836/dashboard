package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountBudget;
import com.dashboard.entity.account.AccountBudgetPageInfo;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.service.account.AccountBudgetService;
import com.dashboard.service.account.AccountCategoryService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author konglinghui
 * @description 消费预算服务
 * @date 2020/5/5 23:08
 **/
@RestController
@RequestMapping("/account/budget/rest")
public class AccountBudgetRestController {

    @Reference
    private AccountBudgetService accountBudgetService;

    @Reference
    private AccountCategoryService accountCategoryService;

    /**
     * 初始化消费预算数据
     *
     * @return
     */
    @GetMapping("/initAccountBudget")
    public RestResult initAccountBudget() {
        // 查询所有非一级分类信息
        List<AccountCategory> accountCategoryList = accountCategoryService.findAllChildAccountCategoryList();

        // 组装数据
        List<AccountBudget> accountBudgetList = this.buildAccountBudgetList(accountCategoryList);

        accountBudgetService.insertAccountBudgetByBatch(accountBudgetList);

        return RestResult.success();
    }

    /**
     * 新建消费预算
     *
     * @param accountBudget
     * @return
     * @deprecated
     */
    @PostMapping("/createAccountBudget")
    public RestResult createAccountBudget(@RequestBody AccountBudget accountBudget) {

        accountBudget.setId(SnowflakeIdWorker.generateId());
        accountBudget.setCreateBy("0");
        accountBudget.setUpdateBy("0");
        accountBudget.setCreateTime(DateTimeUtils.currentTimeStamp());
        accountBudget.setUpdateTime(DateTimeUtils.currentTimeStamp());
        accountBudget.setStatus(StatusEnum.ON.getCode());

        accountBudgetService.createAccountBudget(accountBudget);

        return RestResult.success();
    }

    /**
     * 修改消费预算
     *
     * @return
     */
    @PostMapping("/updateAccountBudget")
    public RestResult updateAccountBudget(@RequestBody AccountBudget accountBudget) {

        accountBudget.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountBudgetService.updateAccountBudget(accountBudget);

        return RestResult.success();
    }

    /**
     * 删除消费预算
     *
     * @param id
     * @return
     * @deprecated
     */
    @GetMapping("/deleteAccountBudget/{id}")
    public RestResult deleteAccountBudget(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        accountBudgetService.deleteAccountBudget(id);

        return RestResult.success();
    }

    /**
     * 查询消费预算
     *
     * @param id
     * @return
     */
    @GetMapping("/findAccountBudgetById/{id}")
    public RestResult findAccountBudgetById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        AccountBudget accountBudget = accountBudgetService.findAccountBudgetById(id);

        return RestResult.success(accountBudget);
    }

    /**
     * 查询消费预算列表
     *
     * @param accountBudgetPageInfo
     * @return
     */
    @PostMapping("/findAccountBudgetList")
    public RestResult findAccountBudgetList(@RequestBody AccountBudgetPageInfo accountBudgetPageInfo) {

        Page<AccountBudget> page = accountBudgetService.findAccountBudgetList(accountBudgetPageInfo);

        return RestResult.success(page);
    }

    /**
     * 组装数据
     *
     * @param accountCategoryList
     * @return
     */
    private List<AccountBudget> buildAccountBudgetList(List<AccountCategory> accountCategoryList) {
        List<AccountBudget> accountBudgetList = new ArrayList<>();

        accountCategoryList.forEach(accountCategory -> {
            AccountBudget accountBudget = AccountBudget.builder()
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

            accountBudgetList.add(accountBudget);
        });

        return accountBudgetList;
    }
}
