package com.dashboard.start;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author konglinghui
 * @description 配置使用外置tomcat启动
 * @date 2019/12/21 15:47
 **/
public class ConsumerServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 参数是之前main方法所在类
        return builder.sources(ConsumerApplication.class);
    }
}