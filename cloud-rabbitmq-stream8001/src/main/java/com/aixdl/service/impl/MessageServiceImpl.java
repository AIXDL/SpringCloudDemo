package com.aixdl.service.impl;

import com.aixdl.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: 定义消息的发送者
 * @date 2023-07-21 13:37
 * @version: 1.0
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String message = "自定义消息发送";
        output.send(MessageBuilder.withPayload(message).build());
        return "success";
    }
}
