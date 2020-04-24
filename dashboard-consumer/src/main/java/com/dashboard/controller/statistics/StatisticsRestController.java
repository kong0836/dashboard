package com.dashboard.controller.statistics;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.service.account.AccountRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description 统计数据接口
 * @date 2020/4/24 12:42
 **/
@RestController
@RequestMapping("/statistics")
public class StatisticsRestController {

    @Reference
    private AccountRecordService accountRecordService;

}
