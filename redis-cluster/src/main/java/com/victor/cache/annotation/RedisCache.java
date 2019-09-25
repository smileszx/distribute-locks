package com.victor.cache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * 注解功能，代理service命中缓存则从缓存中读取数据，
 * 否则从service业务逻辑获得，并存入缓存
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface RedisCache {

    /**
     * 数据返回类型
     * @return
     */
    Class type();

    /**
     * 数据缓存时间单位s秒
     * @return
     */
    int cacheTime() default 600;

}