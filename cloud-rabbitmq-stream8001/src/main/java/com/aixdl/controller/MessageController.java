package com.aixdl.controller;

import com.aixdl.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-21 13:52
 * @version: 1.0
 */
@RestController
@Slf4j
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/stream/send")
    public String send() {
        return messageService.send();
    }
}
