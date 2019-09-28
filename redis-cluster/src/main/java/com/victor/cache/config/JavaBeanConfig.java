package com.victor.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description
 * Java Bean 配置
 *
 * @Author victor su
 * @Date 2019/9/28 21:14
 **/
@Configuration
@ImportResource(locations = {"classpath:spring-beans.xml"})
public class JavaBeanConfig {
}
