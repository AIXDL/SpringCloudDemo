package com.aixdl.controller;

import com.aixdl.entity.CommonResult;
import com.aixdl.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-04 09:03
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {
    /*
    * restTemplate 转发请求是json格式的，所以需要在实体类上加上@RequestBody注解
    * restTemplate返回的格式也是json格式的，所以可以不用加@RequestBody注解
    *
    * */
    @Resource
    private RestTemplate restTemplate;
    /*如果是集群，这里的地址应该是一个变量，通过http://服务名来访问，这里为了方便直接写死
    *在restTemplate中加上@LoadBalanced注解表示开启负载均衡 默认是轮询
     */
//    private final String PAYMENT_URL = "http://localhost:8001/payment";
    private final String PAYMENT_URL = "http://cloud-payment-service/payment";

    @GetMapping("/add")
    public Payment add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/add",payment,Payment.class);
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        Payment forObject = restTemplate.getForObject(PAYMENT_URL + "/queryById/" + id, Payment.class);
        return new CommonResult(200,"查询成功",forObject);

    }

    @GetMapping("/getPaymentEntity/{id}")
    public CommonResult<Payment>  getPaymentEntity(@PathVariable("id") Integer id) {
        ResponseEntity<Payment> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/queryById/" + id, Payment.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            Payment body = forEntity.getBody();
            System.out.println(forEntity.getStatusCode()+"\t"+forEntity.getHeaders());
            return new CommonResult<>(200, "查询成功", body);
        } else {
            return new CommonResult<>(444, "查询失败", null);
        }
    }
}
