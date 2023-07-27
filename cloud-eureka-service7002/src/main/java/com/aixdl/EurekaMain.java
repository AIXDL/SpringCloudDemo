package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author AIXDL
 * @description: Eureka两种角色 服务端和客户端
 * @EnableEurekaServer 服务端的启动类，可以接受别人注册进来
 * @date 2023-07-05 08:54
 * @version: 1.0
 */
@SpringBootApplication
//表明这个是Eureka的服务端
@EnableEurekaServer
public class EurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class,args);
    }
}
