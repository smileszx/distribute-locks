package com.victor.cache.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * Mybatis配置类
 * @Author victor su
 * @Date 2019/9/26 11:26
 **/
@Configuration
@MapperScan(basePackages = "com.victor.cache.dao")
public class MyBatisConfig {
}
