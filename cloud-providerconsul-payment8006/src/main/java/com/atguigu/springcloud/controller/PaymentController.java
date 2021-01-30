package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/26 10:22
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String getServerPort() {
        return "springcloud with consul: " + serverPort + " " + IdUtil.randomUUID();
    }

}
