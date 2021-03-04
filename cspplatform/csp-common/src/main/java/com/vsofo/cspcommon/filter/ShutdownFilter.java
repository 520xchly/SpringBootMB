package com.vsofo.cspcommon.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.vsofo.cspcommon.utils.HttpRequestExtension;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * 远程关闭服务过滤器 shutdown配置 ip白名单
 */
@Slf4j
@Configuration
public class ShutdownFilter implements Filter {

    private String[] shutdownIpWhitelist;

    public ShutdownFilter(String[] shutdownIpWhitelist) {
        this.shutdownIpWhitelist = shutdownIpWhitelist;
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        String ip = HttpRequestExtension.getRemoteIpAddress(request);

        log.info("访问shutdown的机器的原始IP：{}", ip);
        if (!isMatchWhiteList(ip)) {
            sresponse.setContentType("application/json");
            sresponse.setCharacterEncoding("UTF-8");
            PrintWriter writer = sresponse.getWriter();
            writer.write("{\"code\":401}");
            writer.flush();
            writer.close();
            return;
        }
        log.info("远程关闭服务shutdown成功的机器的原始IP：{}", ip);

        filterChain.doFilter(srequest, sresponse);
    }

    /**
     * 匹配是否是白名单
     * 
     * @param ip
     * @return
     */
    private boolean isMatchWhiteList(String ip) {
        List<String> list = Arrays.asList(shutdownIpWhitelist);
        return list.stream().anyMatch(item -> ip.equals(item));
    }

}
