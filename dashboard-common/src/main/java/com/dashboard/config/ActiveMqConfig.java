package com.dashboard.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author konglinghui
 * @description 消息队列配置类
 * @date 2020/3/14 23:55
 **/
@Configuration
public class ActiveMqConfig {

    /**
     * 定义存放消息的队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("ActiveMQQueue");
    }
}
