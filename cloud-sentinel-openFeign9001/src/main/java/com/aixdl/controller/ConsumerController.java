package com.aixdl.controller;

import com.aixdl.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-24 18:27
 * @version: 1.0
 */
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;
    @GetMapping("/hotKey")
    public String hotKey() {
        return consumerService.hotKey();
    }
}
