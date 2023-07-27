package com.aixdl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-22 14:54
 * @version: 1.0
 */
@RestController
public class OrderController {
    @Value("${server.port}")
    private String port;
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/nacos/getPaymentInfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/"+id + port, String.class);
    }


}
