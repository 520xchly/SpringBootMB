package com.vsofo.cspcommon.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * htpp请求扩展功能
 */
public class HttpRequestExtension {

    /**
     * 获取请求的远程ip地址
     */
    public static String getRemoteIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取请求的Authentication
     */
    public static String getRequestAuthentication(HttpServletRequest request) {
        return request.getHeader("Authentication");
    }

    /**
     * 获取请求的Referer
     */
    public static String getRequestReferer(HttpServletRequest request) {
        return request.getHeader("Referer");
    }

    /**
     * 获取请求的UserAgent
     */
    public static String getRequestUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent");
    }

}
