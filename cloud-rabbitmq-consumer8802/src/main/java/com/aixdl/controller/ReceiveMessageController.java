package com.aixdl.controller;

import javafx.scene.control.Skin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AIXDL
 * @description:
 * 如果是同一个组，能保证消息只被消费一次，如果不是同一个组，那么消息会被消费多次
 * 默认分组是不同的组，所以消息会被消费多次
 * 解决重复消费步骤
 * 1.在配置文件中配置分组
 * 2.自定义配置为同一个组
 * @date 2023-07-21 14:19
 * @version: 1.0
 */
@RestController
@Slf4j
@EnableBinding(Sink.class)//消费端
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    //监听输入源
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，------>接收到的消息：" + message.getPayload() + "\t port:" + serverPort);
    }
}
