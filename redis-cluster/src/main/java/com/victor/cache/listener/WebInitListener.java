package com.victor.cache.listener;

import com.victor.cache.thread.RequestProcessorThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description
 * Web初始化Listener
 * @Author victor su
 * @Date 2019/9/27 9:20
 **/
public class WebInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*
         * 初始化线程池和内存队列
         */
        RequestProcessorThreadPool.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
