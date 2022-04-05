package com.yaoyue.cloud.controller;

import com.yaoyue.cloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/20 21:30
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    public RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    private static final String URL = "http://cloud-payment-consul";

    @GetMapping("/order/consul")
    public Result getConsulInfo() {
        return restTemplate.getForObject(URL + "/payment/consul", Result.class);
    }
}
