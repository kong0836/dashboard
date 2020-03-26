package com.dashboard.common.enums;

/**
 * @author konglinghui
 * @description 返回结果枚举类
 * @date 2019/9/4 11:27
 **/
public enum RestResultEnum {

    SUCCESS("success", "成功"),
    FAIL("fail", "失败");

    /**
     * 结果
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    RestResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RestResultEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
