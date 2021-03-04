package com.vsofo.cspcommon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.vsofo.cspcommon.utils.HttpRequestExtension;
import lombok.extern.slf4j.Slf4j;

/**
 * 打印过滤器
 */
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        String ip = HttpRequestExtension.getRemoteIpAddress(request);
        log.info("=============");
        log.info("远程请求ip地址为：(" + ip + ")");
        log.info("远程请求RequestURI为：(" + request.getRequestURI() + ")");
        log.info("远程请求RequestURL为：(" + request.getRequestURL() + ")");
        log.info("远程请求RemoteHost为：(" + request.getRemoteHost() + ")");
        log.info("远程请求Authentication为：(" + HttpRequestExtension.getRequestAuthentication(request) + ")");
        log.info("远程请求Referer为：(" + HttpRequestExtension.getRequestReferer(request) + ")");
        log.info("远程请求User-Agent为：(" + HttpRequestExtension.getRequestUserAgent(request) + ")");
        log.info("=============");

        filterChain.doFilter(srequest, sresponse);
    }

}
