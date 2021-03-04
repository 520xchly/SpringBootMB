package com.vsofo.cspcommon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * spring boot的注入容器 自定义配置 注入对象
 */
@Component
public class MvcDIConfig {
    @Value("${machine.code:1}")
    private int machineCode;

    

}
