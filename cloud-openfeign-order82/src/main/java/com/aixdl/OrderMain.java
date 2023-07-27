package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author AIXDL
 * @description: openFeign完成服务调用
 * 1.引入openfeign依赖
 * 2.在主启动类上添加@EnableFeignClients注解
 * 3.编写接口
 * @Component
 * @FeignClient(value = "cloud-payment-service")
 * 4.在接口中编写调用的方法
 * @GetMapping("/payment/queryById/{id}")要和被调用的方法的请求路基一致
 * @date 2023-07-14 20:17
 * @version: 1.0
 */
/**
 * openfeign日志打印级别
 * none 默认的，不显示任何日志
 * basic 仅记录请求方法、URL、响应状态码及执行时间
 * headers 除了basic中定义的信息之外，还有请求和响应的头信息
 * full 除了headers中定义的信息之外，还有请求和响应的正文及元数据
 **/
@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);

    }
}
