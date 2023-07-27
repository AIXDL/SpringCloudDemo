package com.aixdl.controller;

import com.aixdl.entity.CommonResult;
import com.aixdl.entity.Payment;
import com.aixdl.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-14 20:19
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/openfeign/consumer")
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        Payment forObject = paymentFeignService.queryById(id);
        return new CommonResult(200,"查询成功",forObject);

    }

    @GetMapping("/add")
    public Payment add(Payment payment){
        return paymentFeignService.add(payment,11);
    }

    /**
     * @Author AIXDL
     * @Description openfeign超时测试
     * 默认的超时时间是1秒钟，如果调用时间超过1秒钟就会报错
     * @Date 2023-07-14 22:33
     * @param
     * @return java.lang.String
     **/
    @GetMapping("/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }

}
