package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author SouthMaple
 * @date 2021-01-31
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344Application {
    public static void main(String[] args) { SpringApplication.run(ConfigCenter3344Application.class, args); }
}
