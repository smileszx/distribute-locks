package com.victor.cache.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * JDK动态代理，面向接口的代理模式
 * 只能为接口创建代理实例
 * 1. 通过实现InvocationHandler接口创建自己的调用处理器
 * 2. 通过为Proxy类指定ClassLoader对象和一组interface来创建动态代理
 * 3. 通过反射机制获取动态代理类的构造函数，其唯一参数类型就是调用处理器接口类型
 * 4. 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数传入
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
