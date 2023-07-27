package com.aixdl.controller;

import com.aixdl.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-15 10:17
 * @version: 1.0
 */
@RestController
@Slf4j
public class HystrixController {
    @Resource
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = hystrixService.paymentInfo_OK(id);
        log.info("result = " + result);
        return result;
    }

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = null;
        try {
            result = hystrixService.paymentInfo_TimeOut(id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("result = " + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String s = hystrixService.paymentCircuitBreaker(id);
        return s;
    }
}
