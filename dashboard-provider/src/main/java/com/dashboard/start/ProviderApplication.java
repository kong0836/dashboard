package com.dashboard.start;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * EnableJms-启动消息队列
 *
 * @author konglinghui
 * @description 启动类
 * @date 2019/11/14 19:59
 **/
@EnableJms
// @MapperScan(basePackages = "com.dashboard.mapper")
@ComponentScan(basePackages = {"com.dashboard.*"})
@EnableDubbo(scanBasePackages = "com.dashboard.service.impl")
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
