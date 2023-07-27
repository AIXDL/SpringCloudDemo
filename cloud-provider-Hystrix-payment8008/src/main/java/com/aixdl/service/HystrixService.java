package com.aixdl.service;

public interface HystrixService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id) throws InterruptedException;

    String paymentCircuitBreaker(Integer id);
}
