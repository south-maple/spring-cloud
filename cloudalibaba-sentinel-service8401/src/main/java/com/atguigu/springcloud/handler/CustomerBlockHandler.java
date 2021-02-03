package com.atguigu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;

import static com.atguigu.springcloud.entity.CommonResult.success;

/**
 * @author SouthMaple
 * @date 2021-02-03
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException e) {
        return success("按客户自定义1，global handler exception");
    }

    public static CommonResult handlerException2(BlockException e) {
        return success("按客户自定义2，global handler exception");
    }
}
