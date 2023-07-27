package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author AIXDL
 * @description: gateway网关
 * 1.路由
 * 2.断言
 * 3.过滤
 * 引入了gateway依赖的话，就不需要spring-boot-start-web依赖了，会冲突
 * 配置url映射 主要是为了保护微服务的安全，不让外部直接访问微服务 通过网关访问指定端口会自动转发到微服务
 *   cloud:
 *     gateway:
 *       discovery:
 *         locator:
 *           enabled: true #开启从注册中心动态创建路由的功能，利用微服务名进行路由
 *       routes:
 *         - id: payment_routh #路由的ID，没有规定规则但要求唯一，建议配合服务名
 * #          uri: http://localhost:8001 #匹配后提供服务的路由地址
 *           uri: lb://cloud-payment-service #匹配后提供服务的路由地址,可实现负载均衡
 *           predicates:
 *             - Path=/payment/queryById/** #断言，路径相匹配的进行路由
 *         - id: payment_routh2 #路由的ID，没有规定规则但要求唯一，建议配合服务名
 * #          uri: http://localhost:8001 #匹配后提供服务的路由地址
 *           uri: lb://cloud-payment-service #匹配后提供服务的路由地址,可实现负载均衡
 *           predicates:
 *              - Path=/payment/discovery/** #断言，路径相匹配的进行路由
 * @date 2023-07-17 21:57
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
