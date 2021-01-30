package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/27 14:26
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrder80Application {
    public static void main(String[] args) { SpringApplication.run(HystrixOrder80Application.class, args); }
}
