package com.dashboard.controller.analysis;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.entity.analysis.vo.AccountAnalysisVO;
import com.dashboard.service.analysis.AccountTotalService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description 统计数据接口
 * @date 2020/4/24 12:42
 **/
@RestController
@RequestMapping("/analysis/rest")
public class AnalysisRestController {

    @Reference
    private AccountTotalService accountTotalService;

    @PostMapping("/findAccountTotal")
    public RestResult findAccountTotal(@RequestBody AccountAnalysisVO accountAnalysisVO) {

        //TODO ++

        return RestResult.success();
    }
}
