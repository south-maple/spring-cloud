package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果处理类
 *
 * @author SouthMaple
 * @date 2021-01-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    public CommonResult(long code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult<T> success(String message, T data) {
        CommonResult commonResult = success(data);
        commonResult.setMessage(message);
        return commonResult;
    }

    public static <T> CommonResult<T> success(T data) {
        if (data instanceof Boolean) {
            return (Boolean) data ? ok() : fail();
        }
        return null == data ? fail() : ok(data);
    }

    public static <T> CommonResult<T> ok() {
        return new CommonResult<>(20000, "成功");
    }

    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<>(20000, "成功", data);
    }

    public static <T> CommonResult<T> fail() {
        return new CommonResult<>(20001, "失败");
    }

    public static <T> CommonResult<T> fail(T data) {
        return new CommonResult<>(20001, "失败", data);
    }

}
