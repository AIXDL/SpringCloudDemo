package com.aixdl.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.aixdl.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-15 10:12
 * @version: 1.0
 */

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        String info= "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O哈哈~";
        return info;
    }

    @Override
    // 服务降级 只要是服务不可用或者超时，都会调用fallbackMethod中指定的方法
    @HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties = {
            // 设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) throws InterruptedException {
        Thread.sleep(3000);
//        int age = 10/0;
        String info= "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~ 耗时3秒";
        return info;
    }

    public String timeoutFallback(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 服务端8008系统繁忙或者运行报错，请稍后再试,id: " + id + "\t" + "o(╥﹏╥)o";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod ="paymentCircuitBreakerFallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("*********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreakerFallback(Integer id){
        return "服务熔断了，id: " + id + "\t" + "o(╥﹏╥)o";
    }
}
