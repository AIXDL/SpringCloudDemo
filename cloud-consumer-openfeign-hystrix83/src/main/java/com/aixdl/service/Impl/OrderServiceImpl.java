package com.aixdl.service.Impl;

import com.aixdl.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-15 14:46
 * @version: 1.0
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "id="+id+"OrderServiceImpl fall back-paymentInfo_OK";
    }
    @HystrixCommand(commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "id="+id+"OrderServiceImpl fall back-paymentInfo_TimeOut";
    }
}
