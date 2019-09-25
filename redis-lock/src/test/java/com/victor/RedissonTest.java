package com.victor;

import com.victor.lock.config.RedissonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.ClusterNodesGroup;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RedissonConfig.class)
public class RedissonTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedissonTest.class);

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void set() {
        // 设置字符串
//        RBucket<String> keyObj = redissonClient.getBucket("k1");
//        keyObj.set("v1236");

        ClusterNodesGroup group =redissonClient.getClusterNodesGroup();
        LOGGER.info(group.getNodes().toString());

        RLock rLock =redissonClient.getLock("redis-cluster-lock");

        LOGGER.info(rLock.getName());
    }
}