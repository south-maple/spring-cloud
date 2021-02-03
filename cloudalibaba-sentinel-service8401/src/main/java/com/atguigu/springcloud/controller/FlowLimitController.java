package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author SouthMaple
 * @date 2021-02-03
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        log.info("[{}], ...testA", Thread.currentThread().getName());
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        int i = 10 / 0;
        return "-----------测试 异常比例";
    }

    @GetMapping("/testE")
    public String testE() {
        int i = 10 / 0;
        return "-----------测试 异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        // int i = 10 / 0;
        return "---------------testHotKey, p1=" + p1 + ", p2=" + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "-----------deal_testHotKey o(╥﹏╥)o";
    }
}
