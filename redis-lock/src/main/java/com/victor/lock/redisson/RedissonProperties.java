package com.victor.lock.redisson;

import lombok.Data;

/**
 * @Description
 * Redisson配置文件
 * @Author victor su
 * @Date 2019/9/22 21:24
 **/
@Data
public class RedissonProperties {

    /**
     * 超时时间
     */
    private int timeout = 3000;

    /**
     * redis地址
     */
    private String address;

    /**
     * redis密码
     */
    private String password;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize= 10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;
}
