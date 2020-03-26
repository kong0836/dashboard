package com.dashboard.enums.permission;

/**
 * @author konglinghui
 * @description 菜单类型
 * @date 2020/3/16 19:58
 **/
public enum MenuTypeEnum {

    /**
     * 目录
     */
    DIRECTORY(0, "目录"),

    /**
     * 菜单
     */
    MENU(1, "菜单"),

    /**
     * 按钮
     */
    BUTTON(2, "按钮"),
    ;

    /**
     * 类型
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    MenuTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
