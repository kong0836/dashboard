package com.dashboard.common.enums;

/**
 * @author konglinghui
 * @description 状态枚举类
 * @date 2020/3/29 18:09
 **/
public enum StatusEnum {

    ON(0, "启用"),
    OFF(1, "禁用");

    /**
     * 状态值
     */
    private Integer code;

    /**
     * 状态类型
     */
    private String type;

    StatusEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
