package com.atguigu.springcloud.service;

import com.alibaba.csp.sentinel.command.annotation.CommandMapping;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author SouthMaple
 * @date 2021-02-03
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回，----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}
