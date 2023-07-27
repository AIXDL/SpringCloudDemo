package com.aixdl.service;

import com.aixdl.service.impl.ConsumerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-sentinel-service",fallback = ConsumerServiceImpl.class)
public interface ConsumerService {
    @GetMapping("/hotKey")
    public String hotKey();
}
