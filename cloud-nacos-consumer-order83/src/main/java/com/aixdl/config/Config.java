package com.aixdl.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-22 14:49
 * @version: 1.0
 */
@Configuration
public class Config {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();

    }
}
