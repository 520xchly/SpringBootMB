package com.vsofo.cspcommon.config;

import com.vsofo.cspcommon.filter.LogFilter;
import com.vsofo.cspcommon.filter.ShutdownFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MVC 过滤器注册
 */
@Configuration
public class MvcFilterRegist {

    @Value("${shutdown.whitelist:0:0:0:0:0:0:0:1,127.0.0.1}")
    private String[] shutdownIpWhitelist;
    @Value("${server.servlet.context-path:/}")
    private String contextPath;
    @Value("${management.endpoints.web.base-path:/actuator}")
    private String managerPath;
    @Value("${management.endpoints.web.path-mapping.shutdown:shutdown}")
    private String shutdownPattern;

    /**
     * shutdown 过滤器
     */
    @Bean
    public FilterRegistrationBean shuadownFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ShutdownFilter(shutdownIpWhitelist));
        String shutdownPath = contextPath + managerPath + "/" + shutdownPattern;
        shutdownPath = shutdownPath.replace("//", "/");
        registration.addUrlPatterns(shutdownPath);
        registration.setName("shutdownFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 打印过滤器
     */
    @Bean
    public FilterRegistrationBean logFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new LogFilter());
        registration.addUrlPatterns("/*");
        registration.setName("logFilter");
        registration.setOrder(2);
        return registration;
    }

}
