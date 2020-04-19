package com.dashboard.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author konglinghui
 * @description 返回结果枚举类
 * @date 2019/9/4 11:27
 **/
@Getter
@AllArgsConstructor
@ToString
public enum BaseResultEnum {

    /**
     * 成功
     */
    SUCCESS("success", "成功"),

    /**
     * 失败
     */
    FAIL("fail", "失败"),

    /**
     * 参数异常
     */
    PARAM_ERROR("PARAM_ERROR", "参数异常"),
    ;

    /**
     * 结果
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;
}
