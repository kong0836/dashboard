package com.dashboard.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * redis集群配置类
 *
 * @author konglinghui
 * @date 2020/10/27 18:14
 **/
@Configuration
public class RedisClusterConfig extends CachingConfigurerSupport {

    @Resource
    private RedisClusterConfigProperties redisClusterConfigProperties;

    @Bean
    public JedisCluster cluster() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 截取集群节点
        String[] cluster = redisClusterConfigProperties.getNodes().toArray(new String[0]);
        // 创建set集合
        Set<HostAndPort> nodes = new HashSet<>();
        // 循环数组把集群节点添加到set集合中
        for (String node : cluster) {
            String[] host = node.split(":");
            //添加集群节点
            nodes.add(new HostAndPort(host[0], Integer.parseInt(host[1])));
        }
        return new JedisCluster(nodes,
                redisClusterConfigProperties.getConnectionTimeout(),
                redisClusterConfigProperties.getSoTimeout(),
                redisClusterConfigProperties.getMaxAttempts(),
                poolConfig);
    }

    @Bean
    public RedisClusterConfiguration clusterConfig() {
        RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(redisClusterConfigProperties.getNodes());
        clusterConfig.setMaxRedirects(redisClusterConfigProperties.getMaxAttempts());
        clusterConfig.setPassword(RedisPassword.of(redisClusterConfigProperties.getPassword()));

        return clusterConfig;
    }

    @Bean
    public JedisConnectionFactory connectionFactory(RedisClusterConfiguration clusterConfig) {
        return new JedisConnectionFactory(clusterConfig);
    }

    /**
     * RedisTemplate配置
     *
     * @param connectionFactory redis连接工厂
     *                          key 为String类型
     *                          value 为Object类型,都使用Jackson2JsonRedisSerializer进行序列化
     */
@Bean(name = "redisTemplate")
public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(connectionFactory);

        RedisSerializer<String> stringSerializer = new StringRedisSerializer();

        // key序列化
        template.setKeySerializer(stringSerializer);
        // hash-key序列化
        template.setHashKeySerializer(stringSerializer);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(om.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash-value序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        // 更新key-value序列化方式
        template.afterPropertiesSet();

        return template;
    }
}
