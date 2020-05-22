package com.dashboard.entity.analysis;

import com.dashboard.enums.analysis.AnalysisTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费记录统计查询参数
 * @date 2020/5/22 18:50
 **/
@Data
public class AccountAnalysisVO implements Serializable {

    private static final long serialVersionUID = -5876987601778743852L;

    /**
     * 类型
     *
     * @see AnalysisTypeEnum
     */
    private String type;
}
