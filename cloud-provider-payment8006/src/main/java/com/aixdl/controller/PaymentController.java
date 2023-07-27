package com.aixdl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-13 20:10
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;

    static final String PAYMENT_URL = "http://consul-provider-payment";

    @GetMapping("/consul")
    public String paymentInfo(){
        return "spring cloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }


}
