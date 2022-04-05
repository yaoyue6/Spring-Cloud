package com.yaoyue.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yaoyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/26 23:42
 * @description
 */
@Slf4j
@DefaultProperties(defaultFallback = "hystrixGlobalFallback")
@RestController
public class HystrixController {

    @Resource
    PaymentService paymentService;

//    @HystrixCommand
    @GetMapping("/hystrix/ok/{id}")
    public String getHystrixInfoOk(@PathVariable("id") Long id) {
//        int i = 10 / 0;
        return paymentService.getPaymentInfoOk(id);
    }

    @GetMapping("/hystrix/fail/{id}")
//    @HystrixCommand(fallbackMethod = "getHystrixInfoFailHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String getHystrixInfoFail(@PathVariable("id") Long id) {
//        int i = 10 / 0;
        return paymentService.getPaymentInfoFail(id);
    }

    public String getHystrixInfoFailHandler(Long id) {
        return "消费者端：" + "线程池：" + Thread.currentThread().getName() + "服务超时或失败，请10s后重试，id：" + id;
    }

    public String hystrixGlobalFallback() {
        return "全局服务降级处理...";
    }
}
