package com.dashboard.enums.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author konglinghui
 * @description 汇总方式: 日、周、月、季度、半年、年
 * @date 2020/4/27 22:43
 **/
@Getter
@AllArgsConstructor
public enum AccountTotalTypeEnum {

    /**
     * 日
     */
    CURRENT_DAY("DAY", "日"),

    /**
     * 周
     */
    CURRENT_WEEK("WEEK", "周"),

    /**
     * 月
     */
    CURRENT_MONTH("MONTH", "月"),

    /**
     * 季度
     */
    CURRENT_QUARTER("QUARTER", "季度"),

    /**
     * 半年
     */
    HALF_YEAR("HALF_YEAR", "半年"),

    /**
     * 年
     */
    CURRENT_YEAR("YEAR", "年"),
    ;

    private String type;

    private String name;
}
