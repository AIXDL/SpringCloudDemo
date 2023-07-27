package com.aixdl.service.impl;

import com.aixdl.service.ConsumerService;
import org.springframework.stereotype.Component;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-24 18:34
 * @version: 1.0
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String hotKey() {
        return "feign_hotKey出现问题";
    }
}
