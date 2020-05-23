package com.dashboard.service.analysis;

import com.dashboard.entity.analysis.vo.AccountAnalysisVO;
import com.github.abel533.echarts.Option;

/**
 * @author konglinghui
 * @description 消费汇总服务
 * @date 2020/5/22 19:13
 **/
public interface AccountTotalService {

    /**
     * 查询消费记录统计数据
     *
     * @param accountAnalysisVO
     * @return
     */
    Option findAccountTotal(AccountAnalysisVO accountAnalysisVO);
}
