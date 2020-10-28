package com.dashboard.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis集群配置信息
 *
 * @author konglinghui
 * @date 2020/10/27 18:16
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterConfigProperties {

    /**
     * 各个集群节点
     */
    private List<String> nodes;

    /**
     *
     */
    private Integer maxAttempts;

    /**
     *
     */
    private Integer connectionTimeout;

    /**
     *
     */
    private Integer soTimeout;

    /**
     * 密码
     */
    private String password;
}
