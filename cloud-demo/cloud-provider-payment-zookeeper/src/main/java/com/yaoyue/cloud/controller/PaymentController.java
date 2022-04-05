package com.yaoyue.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.entity.Result;
import com.yaoyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author 王东旭
 * @createTime 2022/3/15 10:26
 * @description
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/zk")
    public String getZookeeperInfo() {
        return "zookeeper Info：" + port + UUID.randomUUID();
    }

    @GetMapping(value = "/payment/select/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询数据：" + payment);
        if(payment != null) {
            return Result.success(JSON.toJSONString(payment));
        } else {
            return Result.fail();
        }
    }
}
