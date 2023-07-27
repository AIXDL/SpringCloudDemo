package com.aixdl.service.impl;

import com.aixdl.service.SentinelService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-24 15:17
 * @version: 1.0
 */
@Service
@Slf4j
public class SentinelServiceImpl implements SentinelService {
    @Override
    public String send(String message, String name, String token) {
        System.out.println(message);
        System.out.println(name);
        System.out.println(token);
        log.info("message: " + message + " name: " + name);
        return message;
    }
}
