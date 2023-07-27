package com.aixdl.service;

import com.aixdl.service.Impl.OrderServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//将Hystrix中兜底方法进行抽取，放到Feign接口中，实现解耦 fallback = OrderServiceImpl.class 为兜底类有问题时，调用的类
@FeignClient(value = "cloud-hystrix-payment-service",fallback = OrderServiceImpl.class)
/** 以下为Hystrix的配置
 feign:
 hystrix:
 enabled: true
 **/
public interface OrderService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
