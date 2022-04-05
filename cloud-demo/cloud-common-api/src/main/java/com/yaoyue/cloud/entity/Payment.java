package com.yaoyue.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 王东旭
 * @createTime 2022/3/15 9:38
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 序列号
     */
    private String serial;
}
