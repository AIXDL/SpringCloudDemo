package com.aixdl.controller;

import com.aixdl.handler.MyBlockHandler;
import com.aixdl.service.SentinelService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author AIXDL
 * @description:
 * @SentinelResource 不支持private方法
 * fallback只负责业务异常
 * blockHandler只负责sentinel控制台配置违规
 * 如果fallback和blockHandler都配置了，那么被限流降级而抛出BlockException时只会进入blockHandler处理逻辑 因为blockHandler处理逻辑优先级高于fallback
 * 请求不再进入任何方法，直接被限流降级
 * @SentinelResource(value = "testA", exceptionsToIgnore = {IllegalArgumentException.class}) 忽略某些异常，不走fallback方法
 *
 *
 * 持久化 nacos配置
 * [
 *     {
 *         "resource" :"",资源名
 *         "limitApp": "",来源应用
 *         "grade": 1, 域值类型 0表示线程数 1表示QPS
 *         "count": 1, 单机域值
 *         "strategy": 0,流控模式 0直接，1关联，2链路
 *         "controlBehavior": 0,流控效果 0快速失败 1warm up 2排队等候
 *         "clusterMode": false 是否集群
 *
 *
 *     }
 * ]
 * @date 2023-07-23 14:04
 * @version: 1.0
 */
@RestController
public class SentinelController {
    @Autowired
    private SentinelService sentinelService;
    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }
    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "dealHotKey",fallback = "dealHotKeyException")
    public String hotKey() {
        sentinelService.send("hotKey","hello","123");
        List<Integer> lists=new ArrayList<Integer>();

        return "hotKey";
    }

    public String dealHotKey(BlockException exception) {
        return "deal_hotKey";
    }
    public static String dealHotKeyException() {
        return "deal_hotKey_exception";
    }

    @SentinelResource(value = "testC")
    @GetMapping("/testC")
    public String testC() {
        return "testC";
    }


    //限流解耦
    @GetMapping("/testD")
    @SentinelResource(value = "testD", blockHandlerClass = MyBlockHandler.class, blockHandler = "dealTestD")
    public String testD() {
        return "testD";
    }

    enum Status{
       
    }

}
