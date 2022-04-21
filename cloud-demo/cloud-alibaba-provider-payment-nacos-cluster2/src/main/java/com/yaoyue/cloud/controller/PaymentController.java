package com.yaoyue.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王东旭
 * @createTime 2022/4/10 23:17
 * @description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable Long id) {
        return "nacos register success! server port: " + port + ", id: " + id;
    }
}
