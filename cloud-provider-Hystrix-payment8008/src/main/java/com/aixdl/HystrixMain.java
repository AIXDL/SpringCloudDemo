package com.aixdl;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author AIXDL
 * @description: TODO 服务降级 Hystrix
 * 1.主启动类添加@EnableCircuitBreaker
 * 2.业务类添加@HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties = {})
 * fallbackMethod：指定服务降级处理方法
 * commandProperties：指定服务降级的一些属性
 * @date 2023-07-15 10:09
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain.class,args);
    }

    /*
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目里配置上下面的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
