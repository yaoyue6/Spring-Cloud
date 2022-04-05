package com.yaoyue.cloud.service;

import com.yaoyue.cloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 王东旭
 * @CreateTime 2022/3/22 22:07
 * @Description
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentService {

    /**
     * 获取支付id 和生产者的service保持一致
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/select/{id}")
    Result getPaymentById(@PathVariable("id") Long id);
}
