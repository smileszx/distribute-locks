package com.victor.cache.redis;

/**
 * @Description
 * Jedis客户端自定义接口方法
 * @Author victor su
 * @Date 2019/9/25 18:39
 **/
public interface JedisService {

    boolean exists(String key);

    String set (String key, String value,int seconds);

    String set (String key, String value);

    String get (String key);
}
