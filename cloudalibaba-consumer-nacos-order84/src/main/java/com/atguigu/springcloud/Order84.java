package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SouthMaple
 * @date 2021-02-03
 */
@SpringBootApplication
@EnableFeignClients
public class Order84 {
    public static void main(String[] args) { SpringApplication.run(Order84.class, args); }
}
