package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-19 20:24
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
