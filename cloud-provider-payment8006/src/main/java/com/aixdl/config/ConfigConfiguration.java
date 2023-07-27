package com.aixdl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-13 20:12
 * @version: 1.0
 */
@Configuration
public class ConfigConfiguration {
    @Bean
    public RestTemplate configBean(){
        return new RestTemplate();
    }
}
