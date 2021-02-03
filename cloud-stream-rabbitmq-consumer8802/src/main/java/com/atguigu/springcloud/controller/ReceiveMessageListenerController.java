package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SouthMaple
 * @date 2021-01-31
 */
@Slf4j
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    // @StreamListener注解, 监听队列, 用于消费者队列的消息接收
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号 ------> 接收到的消息：[{}]; port:[{}]", message.getPayload(), serverPort);
    }
}
