package com.victor.cache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis 读取配置文件的属性值
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisConfigurationProperties {

    /**
     * Redis Cluster 集群节点
     */
    private List<String> nodes = new ArrayList<>();

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}