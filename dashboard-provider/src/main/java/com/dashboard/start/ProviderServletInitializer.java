package com.dashboard.start;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author konglinghui
 * @description TODO
 * @date 2019/12/21 15:47
 **/
public class ProviderServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 参数是之前main方法所在类
        return builder.sources(ProviderApplication.class);
    }
}