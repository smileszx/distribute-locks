package com.victor.cache.proxy;

import com.victor.cache.service.UserService;
import com.victor.cache.service.impl.UserServiceImpl;

/**
 * @Description
 * JDK 动态代理客户端
 * @Author victor su
 * @Date 2019/10/4 23:18
 **/
public class JDKProxyClient {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserServiceJDKProxy proxy = new UserServiceJDKProxy();
        proxy.setObject(userService);

        UserService proxyUserService = (UserService) proxy.createProxyedObj();

        proxyUserService.testJDKProxy();

    }
}
