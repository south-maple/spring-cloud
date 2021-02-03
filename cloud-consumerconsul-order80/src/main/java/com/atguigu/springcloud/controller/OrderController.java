package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/26 10:29
 */
@RestController
public class OrderController {
    private static final String URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consumerPayment() {
        return restTemplate.getForObject(URL + "/payment/consul", String.class);
    }
}
