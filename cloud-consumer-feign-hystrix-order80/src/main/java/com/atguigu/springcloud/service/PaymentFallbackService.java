package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/27 21:34
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-[paymentInfo_OK],o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-------PaymentFallbackService fall back-[paymentInfo_Timeout],o(╥﹏╥)o";
    }
}
