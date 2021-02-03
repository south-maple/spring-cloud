package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author SouthMaple
 * @date 2021-01-31
 */
// @EnableBinding 注解是绑定channel和exchange绑定在一起，Source 定义消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    // 消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("生产者发送消息 ------> [{}]", serial);
        return "生产者发送消息: " + serial;
    }
}
