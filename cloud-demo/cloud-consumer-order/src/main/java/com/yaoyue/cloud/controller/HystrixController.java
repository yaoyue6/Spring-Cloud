package com.yaoyue.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/25 18:20
 * @description 测试hystrix熔断
 */
@Slf4j
@RestController
public class HystrixController {

    @Resource
    RestTemplate restTemplate;

    private static final String URL = "http://cloud-hystrix-server";

    @GetMapping("/order/hystrix/ok/{id}")
    public String getPaymentInfoOk(@PathVariable Long id) {
        return restTemplate.getForObject(URL + "/payment/hystrix/ok/" + id, String.class);
    }

    @GetMapping("/order/hystrix/fail/{id}")
    public String getPaymentInfoFail(@PathVariable Long id) {
        return restTemplate.getForObject(URL + "/payment/hystrix/fail/" + id, String.class);
    }
}
