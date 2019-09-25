package com.victor.cache.redis.service;

import com.victor.cache.redis.service.JedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * @Description
 * Jedis Service 实现类
 *
 * @Author victor su
 * @Date 2019/9/25 18:39
 **/
@Service
public class JedisServiceImpl implements JedisService {

    @Resource
    private JedisCluster jedisCluster;

    @Override
    public boolean exists(String key) {
        return jedisCluster.exists(key);
    }

    @Override
    public String set(String key, String value, int seconds) {
        SetParams params = new SetParams();
        params.ex(seconds);
        return jedisCluster.set(key, value, params);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key,value);
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }
}
