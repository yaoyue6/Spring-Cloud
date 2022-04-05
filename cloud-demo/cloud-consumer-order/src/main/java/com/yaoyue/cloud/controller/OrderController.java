package com.yaoyue.cloud.controller;

import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.entity.Result;
//import com.yaoyue.cloud.loadbalance.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/15 17:55
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    /**
     * 不能写死ip，需要写明服务名，之后根据服务名去注册中心获取服务。由于是服务集群，所以需要为restTemplate加上负载均衡注解
     */
    private static final String URL = "http://cloud-payment-service";

//    @Resource
//    private LoadBalancer loadBalancer;

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/order/select/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        String url = URL + "/payment/select/" + id;
        return restTemplate.getForObject(url, Result.class);
    }

    @PostMapping(value = "/order/insert")
    public Result insert(@RequestBody Payment payment) {
        String url = URL + "/payment/insert/";
        return restTemplate.postForObject(url, payment, Result.class);
    }
}
