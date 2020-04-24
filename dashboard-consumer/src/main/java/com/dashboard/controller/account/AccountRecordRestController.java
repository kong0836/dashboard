package com.dashboard.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.service.account.AccountRecordService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //TODO ++
        accountRecord.setId(SnowflakeIdWorker.generateId());
        accountRecord.setCreateTime(DateTimeUtils.currentTimeStamp());

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
        //TODO ++

        accountRecord.setUpdateTime(DateTimeUtils.currentTimeStamp());

        accountRecordService.updateAccountRecord(accountRecord);

        return RestResult.success();
    }

    /**
     * 查询消费记录列表
     *
     * @return
     */
    @PostMapping("/findAccountRecordList")
    public RestResult findAccountRecordList() {
        //TODO ++
        //  accountRecordService.findAccountRecordList();

        return RestResult.success();
    }

    /**
     * 删除消费记录
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteAccountRecord/{id}")
    public RestResult deleteAccountRecord(@PathVariable String id) {
        //TODO ++

        return RestResult.success();
    }
}
