package com.victor.cache.bean;

/**
 * @Description
 * 测试服务接口实现类
 * @Author victor su
 * @Date 2019/9/28 21:25
 **/
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        return "hello, my name is " + TestServiceImpl.class.getName();
    }
}
