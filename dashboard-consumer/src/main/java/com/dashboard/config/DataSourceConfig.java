package com.dashboard.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author konglinghui
 * @description 数据源配置
 * @date 2019/11/27 20:07
 **/
@Configuration
public class DataSourceConfig {

    // @Bean("dataSource")
    // public DataSource dataSource(Environment env) {
    //     HikariDataSource dataSource = new HikariDataSource();
    //     dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
    //     dataSource.setUsername(env.getProperty("spring.datasource.username"));
    //     dataSource.setPassword(env.getProperty("spring.datasource.password"));
    //     dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
    //
    //     return dataSource;
    // }
}
