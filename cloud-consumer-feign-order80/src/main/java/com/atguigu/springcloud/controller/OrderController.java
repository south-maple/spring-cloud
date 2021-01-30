package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/26 14:12
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
    public CommonResult testFeign(@PathVariable long id) {
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/payment/timeout")
    public String testTimeout() {
        return paymentFeignService.timeout();
    }
}
