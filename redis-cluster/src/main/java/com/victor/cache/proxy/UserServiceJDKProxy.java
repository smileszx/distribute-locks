package com.victor.cache.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * JDK动态代理
 * 被代理类，需要实现接口
 * @Author victor su
 * @Date 2019/10/4 23:00
 **/
public class UserServiceJDKProxy implements InvocationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceJDKProxy.class);

    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        LOGGER.info("===================== 华丽的分割线 ======================");
        Object result = method.invoke(object, args);
        LOGGER.info("===================== 华丽的分割线 ======================");
        return result;
    }

    public Object createProxyedObj () {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }
}
