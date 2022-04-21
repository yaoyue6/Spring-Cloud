package com.yaoyue.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/4/14 22:16
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    @Value("${service.url}")
    private String url;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/order/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://cloud-alibaba-nacos-payment-cluster" + "/payment/nacos/" + id, String.class);
    }
}
