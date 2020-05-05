package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountBudget;
import com.dashboard.service.account.AccountBudgetService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 新建消费预算
     *
     * @param accountBudget
     * @return
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
     */
    @GetMapping("/deleteAccountBudget/{id}")
    public RestResult deleteAccountBudget(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        accountBudgetService.deleteAccountBudget(id);

        return RestResult.success();
    }
}
