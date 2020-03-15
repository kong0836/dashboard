package com.dashboard.start;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * EnableJms-启动消息队列
 *
 * @author konglinghui
 * @description 启动类
 * @date 2019/11/14 19:59
 **/
@EnableJms
@ComponentScan(basePackages = {"com.dashboard.*"})
@EnableDubbo(scanBasePackages = "com.dashboard.service")
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
