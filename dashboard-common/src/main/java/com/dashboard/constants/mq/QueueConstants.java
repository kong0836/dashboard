package com.dashboard.constants.mq;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消息队列常量
 * @date 2020/3/15 23:19
 **/
public final class QueueConstants implements Serializable {

    private QueueConstants() {
    }

    private static final long serialVersionUID = -1146989259430038483L;

    /**
     * 测试
     */
    public static final String TEST_QUEUE = "TEST_QUEUE";
}
