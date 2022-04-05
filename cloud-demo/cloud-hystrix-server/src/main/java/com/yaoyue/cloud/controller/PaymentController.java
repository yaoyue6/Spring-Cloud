package com.yaoyue.cloud.controller;

import com.yaoyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/25 17:08
 * @description
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String getPaymentInfoOk(@PathVariable Long id) {
        return paymentService.paymentInfoOK(id);
    }

    @GetMapping("/payment/hystrix/fail/{id}")
    public String getPaymentInfoFail(@PathVariable Long id) {
        return paymentService.paymentInfoFail(id);
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public String getPaymentInfoCircuit(@PathVariable Long id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
