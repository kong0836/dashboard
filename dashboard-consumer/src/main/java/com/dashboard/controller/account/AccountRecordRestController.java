package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.entity.account.AccountRecordPageInfo;
import com.dashboard.service.account.AccountRecordService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author konglinghui
 * @description 消费记录
 * @date 2020/4/24 12:29
 **/
@RestController
@RequestMapping("/account/record/rest")
public class AccountRecordRestController {

    @Reference
    private AccountRecordService accountRecordService;

    /**
     * 新增消费记录
     *
     * @param accountRecord
     * @return
     */
    @PostMapping("/createAccountRecord")
    public RestResult createAccountRecord(@RequestBody AccountRecord accountRecord) {
        accountRecord.setId(SnowflakeIdWorker.generateId());
        accountRecord.setCreateBy("0");
        accountRecord.setUpdateBy("0");
        accountRecord.setCreateTime(DateTimeUtils.currentTimeStamp());
        accountRecord.setUpdateTime(DateTimeUtils.currentTimeStamp());
        accountRecord.setStatus(StatusEnum.ON.getCode());

        accountRecordService.createAccountRecord(accountRecord);

        return RestResult.success();
    }

    /**
     * 手动更新消费记录
     *
     * @param accountRecord
     * @return
     */
    @PostMapping("/updateAccountRecord")
    public RestResult updateAccountRecord(@RequestBody AccountRecord accountRecord) {
        accountRecordService.updateAccountRecord(accountRecord);

        return RestResult.success();
    }

    /**
     * 查询消费记录列表
     *
     * @return
     */
    @PostMapping("/findAccountRecordList")
    public RestResult findAccountRecordList(@RequestBody AccountRecordPageInfo accountRecordPageInfo) {
        Page<AccountRecord> page = accountRecordService.findAccountRecordList(accountRecordPageInfo);

        return RestResult.success(page);
    }

    /**
     * 删除消费记录
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteAccountRecord/{id}")
    public RestResult deleteAccountRecord(@PathVariable Long id) {
        if (Objects.isNull(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        accountRecordService.deleteAccountRecord(id);

        return RestResult.success();
    }

    /**
     * 查询消费记录
     *
     * @param id
     * @return
     */
    @GetMapping("/findAccountRecordById/{id}")
    public RestResult findAccountRecordById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        AccountRecord accountRecord = accountRecordService.findAccountRecordById(id);

        return RestResult.success(accountRecord);
    }
}
