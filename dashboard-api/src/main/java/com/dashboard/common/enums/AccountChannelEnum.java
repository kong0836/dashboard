package com.dashboard.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author konglinghui
 * @description 消费渠道枚举类
 * @date 2020/3/29 18:09
 **/
@Getter
@AllArgsConstructor
public enum AccountChannelEnum {

    /**
     * 微信
     */
    WECHAT("WECHAT", "微信"),

    /**
     * 支付宝
     */
    ALIPAY("ALIPAY", "支付宝"),

    /**
     * 现金
     */
    CASH("CASH", "现金"),

    /**
     * 其他
     */
    OTHER("OTHER", "其他"),

    ;

    /**
     * 渠道code
     */
    private String code;

    /**
     * 渠道名称
     */
    private String name;
}
