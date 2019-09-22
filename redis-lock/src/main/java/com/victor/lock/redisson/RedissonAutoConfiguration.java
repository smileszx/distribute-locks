package com.victor.lock.redisson;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * Redisson 配置
 */
public class RedissonAutoConfiguration {

    private RedissonProperties redssionProperties;

    public RedissonAutoConfiguration (RedissonProperties redssionProperties) {
        this.redssionProperties = redssionProperties;
    }

    /**
     * 单机模式自动装配
     * @return
     */
    public RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redssionProperties.getAddress())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            serverConfig.setPassword(redssionProperties.getPassword());
        }

        return Redisson.create(config);
    }

    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     * @return
     */
    public RedissonLockUtil redissonLockUtil(RedissonClient redissonClient) {
        RedissonLockUtil redissLockUtil = new RedissonLockUtil();
    	redissLockUtil.setRedissonClient(redissonClient);
		return redissLockUtil;
    }

}