package com.yaoyue.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 王东旭
 * @createTime 2022/3/20 17:49
 * @description
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String getConsulInfo() {
        return "consul Info：" + port + UUID.randomUUID();
    }
}