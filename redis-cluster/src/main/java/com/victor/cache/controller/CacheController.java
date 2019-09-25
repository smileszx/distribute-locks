package com.victor.cache.controller;

import com.victor.cache.service.DataSourceService;
import com.victor.cache.redis.service.JedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * Redis缓存
 * @Author victor su
 * @Date 2019/9/25 16:58
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private JedisService jedisService;
    @Autowired
    private DataSourceService dataSourceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);

    @GetMapping("/test")
    public String sayHello () {
        LOGGER.info("================logger test===============");
        return "hello, redis cluster.";
    }

    @RequestMapping("/set")
    public String set (@RequestParam("key") String key, @RequestParam("value") String value) {

        String result = jedisService.set(key,value);
        LOGGER.info("redis cluster set key={},value={}, result:{}", key,value, result);
        return result;
    }

    @RequestMapping("/get")
    public String getValue (@RequestParam("key") String key) {
        return dataSourceService.findDataByKey(key);
    }
}
