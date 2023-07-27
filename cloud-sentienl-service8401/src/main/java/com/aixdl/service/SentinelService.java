package com.aixdl.service;

import feign.Param;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-24 15:17
 * @version: 1.0
 */
public interface SentinelService {
     String send(String message, String name, String token);
}
