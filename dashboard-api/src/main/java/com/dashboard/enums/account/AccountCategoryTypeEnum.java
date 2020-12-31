package com.dashboard.enums.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author konglinghui
 * @description 消费类型枚举
 * @date 2020/4/27 22:43
 **/
@Getter
@AllArgsConstructor
public enum AccountCategoryTypeEnum {

    /**
     * 收入
     */
    IN(1, "收入"),

    /**
     * 支出
     */
    OUT(2, "支出");

    private Integer type;

    private String name;
}
