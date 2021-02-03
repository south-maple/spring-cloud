package com.atguigu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;

/**
 * @author SouthMaple
 * @date 2021-02-03
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global handlerException----------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义2,global handlerException----------2");
    }
}
