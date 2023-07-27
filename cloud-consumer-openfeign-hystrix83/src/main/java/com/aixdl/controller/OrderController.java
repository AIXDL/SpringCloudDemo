package com.aixdl.controller;

import com.aixdl.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-15 12:08
 * @version: 1.0
 */
@RestController
@Slf4j
// 全局fallback方法 没配置的话，就用默认的 但是一定要加上@HystrixCommand
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private OrderService orderService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = orderService.paymentInfo_OK(id);
        log.info("result = " + result);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            // 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
//
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = orderService.paymentInfo_TimeOut(id);
        log.info("result = " + result);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "我是消费者80 id="+id+"，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，/(ㄒoㄒ)/~~";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
