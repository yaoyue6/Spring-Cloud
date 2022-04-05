package com.yaoyue.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.entity.Result;
import com.yaoyue.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/22 22:02
 * @description
 */
@RestController
public class OrderController {

    @Resource
    PaymentService paymentService;

    @GetMapping("/order/select/{id}")
    public Result getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
}
