package com.dashboard.mq.listener;

import com.dashboard.mq.QueueConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author konglinghui
 * @description TODO
 * @date 2020/3/15 9:06
 **/
@Component
public class MqListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqListener.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @SendTo("SQueue")
    @JmsListener(destination = QueueConstants.TEST_QUEUE)
    public String handleMessage(String name) {
        LOGGER.info("接受mq消息：{}", name);

        return "接受mq消息:" + name;
    }
}
