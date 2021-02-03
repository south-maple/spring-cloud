package com.atguigu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Payment)表实体类
 *
 * @author SouthMaple
 * @date  2021-01-25
 */
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String serial;
}