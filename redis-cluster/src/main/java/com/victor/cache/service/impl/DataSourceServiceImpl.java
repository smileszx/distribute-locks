package com.victor.cache.service.impl;

import com.victor.cache.annotation.RedisCache;
import com.victor.cache.service.DataSourceService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * 模拟数据库实现类
 * @Author victor su
 * @Date 2019/9/25 20:08
 **/
@Service
public class DataSourceServiceImpl implements DataSourceService {
    @Override
    @RedisCache(type = String.class)
    public String findDataByKey(String key) {
        String result = String.format("%s,%s", key, ", from DB.");
        return result;
    }
}
