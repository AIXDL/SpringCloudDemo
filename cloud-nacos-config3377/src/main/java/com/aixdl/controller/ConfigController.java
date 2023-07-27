package com.aixdl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-22 15:35
 * @version: 1.0
 */
@RestController
@RefreshScope//支持Nacos的动态刷新功能。
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
