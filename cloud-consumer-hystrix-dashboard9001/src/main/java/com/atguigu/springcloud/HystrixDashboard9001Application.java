package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/27 22:55
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Application.class, args);
    }
}
