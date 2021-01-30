package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SouthMaple
 * @version 1.0
 * @date 2021/1/25 22:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZooKeeper80Application {
    public static void main(String[] args) { SpringApplication.run(OrderZooKeeper80Application.class, args); }
}
