package com.yaoyue.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 王东旭
 * @CreateTime 2022/3/26 23:39
 * @Description
 */
@Component
@FeignClient(value = "cloud-hystrix-server", fallback = PaymentHystrixService.class)
public interface PaymentService {

    /**
     * 成功
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String getPaymentInfoOk(@PathVariable("id") Long id);

    /**
     * 失败
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/fail/{id}")
    String getPaymentInfoFail(@PathVariable("id") Long id);
}
