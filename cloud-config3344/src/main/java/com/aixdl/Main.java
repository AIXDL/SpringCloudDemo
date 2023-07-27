package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author AIXDL
 * @description: config配置中心 一般是放在github上 这样可以实现分布式配置不同的环境和不同的服务
 * 通过http://localhost:3344/master/config-dev.yml访问
 * 格式是http://localhost:3344/label-name/application-profile.yml profile是环境 比如说dev test prod
 * 无论是自动动态刷新配置还是手动刷新配置，都需要发送post请求 只要发一次请求，所有的客户端都会刷新配置
 * 1.通过发送post请求到http://localhost:3355/actuator/refresh来手动刷新配置
 * 2.通过发送post请求到http://localhost:3344/actuator/bus-refresh来自动刷新配置
 * 动态刷新配置文件的步骤：
 * 1.在需要动态刷新配置的微服务的pom文件中添加actuator依赖和bus-amqp依赖
 * 2.在需要动态刷新配置的微服务的配置文件中添加management.endpoints.web.exposure.include="bus-refresh"
 * 3.在需要动态刷新配置的微服务的主启动类上添加注解@RefreshScope
 *
 * 如果不是动态刷新配置，只是手动刷新配置，那么只需要在需要手动刷新配置的微服务的配置文件中添加management.endpoints.web.exposure.include="*"
 * 每个config微服务都要发送post http://localhost:3355/actuator/refresh
 *
 * 如果需要配置中心定点通知的话，可以发生post请求到http://localhost:3344/actuator/bus-refresh/{destination} destination是要通知的微服务的名称+端口号
 *
 *
 * @date 2023-07-18 21:59
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
