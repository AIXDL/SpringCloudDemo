package com.aixdl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-14 22:55
 * @version: 1.0
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public feign.Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.FULL;
    }
}
