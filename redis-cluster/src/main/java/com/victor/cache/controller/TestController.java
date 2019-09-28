package com.victor.cache.controller;

import com.victor.cache.bean.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * 测试类
 * @Author victor su
 * @Date 2019/9/28 21:31
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/service")
    public String testService () {
        return testService.sayHello();
    }
}
