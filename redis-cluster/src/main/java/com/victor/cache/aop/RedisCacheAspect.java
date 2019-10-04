package com.victor.cache.aop;


import com.alibaba.fastjson.JSON;
import java.lang.reflect.Method;

import com.victor.cache.annotation.RedisCache;
import com.victor.cache.redis.JedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 面向切面编程
 * 暂时注释，2019-09-29
 */
//@Aspect
//@Component
public class RedisCacheAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Autowired
    private JedisService jedisService;

    /**
     * 切点
     */
    @Pointcut("execution(public * com.victor.cache.service..*.find*(..))")
    public void webAspect(){}

    @Around("webAspect()")
    public Object redisCache(ProceedingJoinPoint pjp) throws Throwable {
        //得到类名、方法名和参数
        String redisResult = "";
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        //根据类名，方法名和参数生成key
//        String key = genKey(className,methodName,args);
        String key = String.join(":", "redis-cluster", args.toString());
        LOGGER.info("生成的key[{}]",key);
        //得到被代理的方法
        Signature signature = pjp.getSignature();
        if(!(signature instanceof MethodSignature)){
            throw  new IllegalArgumentException();
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = pjp.getTarget().getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
        //得到被代理的方法上的注解
        Class modelType = method.getAnnotation(RedisCache.class).type();
        int cacheTime = method.getAnnotation(RedisCache.class).cacheTime();
        Object result = null;
        if(!jedisService.exists(key)) {
            LOGGER.info("缓存未命中");
            //缓存不存在，则调用原方法，并将结果放入缓存中
            result = pjp.proceed(args);
            redisResult = JSON.toJSONString(result);
            jedisService.set(key,redisResult,cacheTime);
        } else{
            //缓存命中
            LOGGER.info("缓存命中");
            redisResult = jedisService.get(key);
            //得到被代理方法的返回值类型
            Class returnType = method.getReturnType();
            result = JSON.parseObject(redisResult,returnType);
        }
        return result;
    }

    /**
     * @Description: 生成key
     */
    private String genKey(String className, String methodName, Object[] args) {
        StringBuilder sb = new StringBuilder("SpringBoot:");
        sb.append(className);
        sb.append("_");
        sb.append(methodName);
        sb.append("_");
        for (Object object: args) {
            LOGGER.info("obj:"+object);
            if(object!=null) {
                sb.append(object+"");
                sb.append("_");
            }
        }
        return sb.toString();
    }

}