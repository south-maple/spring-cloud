package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/27 16:21
 */
@Service
public class PaymentHystrixService {

    public String paymentInfo_OK(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "O(∩_∩)O哈哈~";
    }

    /**
     * hystrix配置服务降级
     * 设置3s(hystrix默认1s)内服务没有响应或出现异常，则执行回调方法：`paymentInfo_TimeoutHandler`
     * 注：回调方法除名字不同以外，其他的参数返回值类型保持一致
     *
     * @param id
     * @return java.lang.String
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        // 1. 出现异常情况
        // int i = 10 / 0;
        // 2. 响应超时情况
        int timeout = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + "O(∩_∩)O哈哈~ + 耗时(毫秒)" + timeout;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " 系统繁忙或出现异常, id: " + id + " o(╥﹏╥)o";
    }

    //=========================== 服务熔断 ===========================

    /**
     * 服务的降级->进而熔断->恢复调用链路
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，o(╥﹏╥)o id：" + id;
    }
}
