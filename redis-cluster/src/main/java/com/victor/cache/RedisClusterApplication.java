package com.victor.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 *
 * Redis Cluster 集群测试
 * @Author victor su
 * @Date 2019/9/25 16:55
 **/
@SpringBootApplication
public class RedisClusterApplication {

    /**
     * Redis Cluster 集群测试，启动main方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RedisClusterApplication.class, args);
    }

}
