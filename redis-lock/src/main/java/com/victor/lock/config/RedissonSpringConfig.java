package com.victor.lock.config;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.starter.RedissonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description
 * Redisson配置
 * spring:
 *   redis:
 *     redisson:
 *       config: classpath*:redisson-config.yml
 * @Author victor su
 * @Date 2019/9/26 0:05
 **/
@Configuration
public class RedissonSpringConfig {
    @Resource
    private RedissonProperties redissonProperties;

    @Bean
    public RedissonClient redissonClient () throws IOException {
        Config config = Config.fromYAML(redissonProperties.getConfig());
        return Redisson.create(config);
    }

}
