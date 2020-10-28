package com.dashboard.service.cache;

/**
 * redis缓存服务
 *
 * @author konglinghui
 * @date 2020/10/28 14:00
 **/
public interface RedisService {

    /**
     * set
     *
     * @param key   键
     * @param value 值
     * @return
     */
    void set(String key, Object value);


    /**
     * get
     *
     * @param key 键
     * @return
     */
    <T> T get(String key);
}
