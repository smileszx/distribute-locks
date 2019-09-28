package com.victor.cache.bean;

/**
 * @Description
 * 测试静态方法方法创建bean实例
 * @Author victor su
 * @Date 2019/9/28 21:22
 **/
public class TestBeanFactory {

    /**
     * 静态方法创建TestService实例
     * XML方式配置
     * @return
     */
    public static TestService createServiceBean() {
        return new TestServiceImpl();
    }

}
