package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountCategory;
import com.dashboard.entity.account.AccountCategoryPageInfo;
import com.dashboard.service.account.AccountCategoryService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 创建消费分类
     *
     * @param accountCategory
     * @return
     */
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

        Page<AccountCategory> page = accountCategoryService.findAccountCategoryList(accountCategoryPageInfo);

        return RestResult.success(page);
    }

    /**
     * 查询消费分类菜单树
     *
     * @return
     */
    @GetMapping("/findCategoryTreeList")
    public RestResult findCategoryTreeList() {
        return RestResult.success();
    }
}
