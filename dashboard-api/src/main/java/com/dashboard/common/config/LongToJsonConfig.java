package com.dashboard.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author konglinghui
 * @description long类型转String
 * @date 2020/4/9 22:41
 **/
@Configuration
public class LongToJsonConfig {

    /**
     * 将包装类型Long以String格式返回给前端
     *
     * @return
     */
    @Bean
    public HttpMessageConverters customConverters() {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();

        // 包装类转字符串
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        // 基本数据类型转字符串
        // simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        objectMapper.registerModule(simpleModule);
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);

        return new HttpMessageConverters(jackson2HttpMessageConverter);
    }
}
