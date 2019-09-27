package com.victor.cache.config;

import com.victor.cache.listener.WebInitListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * Web配置
 * @Author victor su
 * @Date 2019/9/27 9:18
 **/
@Configuration
public class WebConfig {

    /**
     * 注册Servlet监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean () {
        ServletListenerRegistrationBean listenerRegistrationBean = new ServletListenerRegistrationBean();
        listenerRegistrationBean.setListener(new WebInitListener());
        return listenerRegistrationBean;
    }
}
