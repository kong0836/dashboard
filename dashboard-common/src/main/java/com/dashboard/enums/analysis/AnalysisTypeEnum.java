package com.dashboard.enums.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author konglinghui
 * @description 统计分析查询类型
 * @date 2020/5/22 18:58
 **/
@Getter
@AllArgsConstructor
public enum AnalysisTypeEnum {

    /**
     * 本周
     */
    CURRENT_WEEK("CURRENT_WEEK", "本周"),

    /**
     * 本月
     */
    CURRENT_MONTH("CURRENT_MONTH", "本月"),

    /**
     * 本年
     */
    CURRENT_YEAR("CURRENT_YEAR", "本年"),
    ;

    /**
     * 类型
     */
    private String code;

    /**
     * 名称
     */
    private String name;
}
