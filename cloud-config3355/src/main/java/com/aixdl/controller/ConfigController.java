package com.aixdl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-19 20:26
 * @version: 1.0
 */
@RestController
@Slf4j
//修改完配置文件后，需要发送post请求到http://localhost:3355/actuator/refresh 才能刷新配置
@RefreshScope //支持config的动态刷新功能

public class ConfigController {
    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
