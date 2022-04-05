package com.yaoyue.cloud.controller;

import com.yaoyue.cloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 王东旭
 * @createTime 2022/3/19 21:37
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://cloud-payment-zookeeper";

    @Value("${server.port}")
    private String port;

    @GetMapping("/order/zk")
    public String getZookeeperInfo() {
        return "zookeeper Info：" + port + UUID.randomUUID();
    }

    @GetMapping("/order/select/{id}")
    public Result getPaymentInfo(@PathVariable Long id) {
        return restTemplate.getForObject(URL + "/payment/select/" + id, Result.class);
    }
}
