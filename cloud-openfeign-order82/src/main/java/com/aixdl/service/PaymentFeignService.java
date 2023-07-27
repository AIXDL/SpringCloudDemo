package com.aixdl.service;

import com.aixdl.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/queryById/{id}")
    Payment queryById(@PathVariable("id") Integer id);

    @PostMapping("/payment/add")
    Payment add(Payment payment, @RequestParam("id") Integer id);

    @GetMapping("/payment/timeout")
    String timeout();

}
