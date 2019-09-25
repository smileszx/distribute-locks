package com.victor.lock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description
 * Redisson 配置
 * @Author victor su
 * @Date 2019/9/25 22:37
 **/
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient () throws IOException {
        // 本例使用的是yaml格式的配置文件，读取使用Config.fromYAML，如果是Json文件，则使用Config.fromJSON
        Config config = Config.fromYAML(RedissonConfig.class.getClassLoader().getResource("redisson-config.yml"));
        return Redisson.create(config);
    }

}
