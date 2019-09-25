package com.victor.cache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/*.yml")
public class RedisConfigurationTest {
 
    @Autowired
    private RedisTemplate redisTemplate;
 
    @Test
    public void redisTemplate() throws Exception {
 
        redisTemplate.opsForValue().set("author", "Damein_xym");
    }
 
}