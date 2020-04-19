package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.service.account.AccountCategoryService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/createAccountCategory")
    public RestResult createAccountCategory(@RequestBody AccountCategory accountCategory) {

        accountCategory.setId(SnowflakeIdWorker.generateId());
        accountCategory.setCreateBy("0");
        accountCategory.setUpdateBy("0");
        accountCategory.setCreateTime(DateTimeUtils.currentTimeStamp());
        accountCategory.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountCategoryService.createAccountCategory(accountCategory);

        return RestResult.success();
    }
}
