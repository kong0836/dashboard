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
    DAY("DAY", "日"),

    /**
     * 周
     */
    WEEK("WEEK", "周"),

    /**
     * 月
     */
    MONTH("MONTH", "月"),

    /**
     * 季度
     */
    QUARTER("QUARTER", "季度"),

    /**
     * 半年
     */
    HALF_YEAR("HALF_YEAR", "半年"),

    /**
     * 年
     */
    YEAR("YEAR", "年"),

    ;

    private String type;

    private String name;
}
