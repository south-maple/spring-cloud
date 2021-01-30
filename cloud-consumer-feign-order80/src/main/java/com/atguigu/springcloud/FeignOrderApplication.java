package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/26 13:55
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class, args);
    }
}
