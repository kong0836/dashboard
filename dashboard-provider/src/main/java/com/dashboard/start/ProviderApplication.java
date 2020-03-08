package com.dashboard.start;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author konglinghui
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.dashboard.*"})
@EnableDubbo(scanBasePackages = "com.dashboard.service.impl")
@MapperScan(basePackages = "com.dashboard.mapper")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
