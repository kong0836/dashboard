package com.dashboard.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author konglinghui
 * @description account数据源配置
 * @date 2020/4/19 10:09
 **/
@Configuration
@MapperScan(basePackages = {"com.dashboard.mapper.account", "com.dashboard.mapper.analysis"},
        sqlSessionTemplateRef = "accountSqlSessionTemplate")
public class AccountDataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDataSourceConfig.class);

    /**
     * 数据源配置对象
     * Primary 表示默认的对象，Autowire可注入，不是默认的得明确名称注入
     *
     * @return
     */
    @Bean
    // @Primary
    @ConfigurationProperties("spring.account.datasource")
    public DataSourceProperties accountDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 数据源对象
     *
     * @return
     */
    @Bean
    public DataSource accountDataSource() {
        DataSourceProperties dataSourceProperties = this.accountDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * 配置事务
     *
     * @param accountDataSource
     * @return
     */
    @Bean
    @Resource
    public PlatformTransactionManager accountTransactionManager(DataSource accountDataSource) {
        return new DataSourceTransactionManager(accountDataSource);
    }

    /**
     * 配置Mapper路径
     *
     * @param dataSource
     * @return
     */
    @Bean
    public SqlSessionFactory accountSqlSessionFactory(@Qualifier("accountDataSource") DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setTypeAliasesPackage("com.dashboard.entity");
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/**Mapper.xml"));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("配置Mapper路径发生异常:{}", e.getMessage());
            }
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 配置SqlSessionTemplate
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate accountSqlSessionTemplate(@Qualifier("accountSqlSessionFactory")
                                                                SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
