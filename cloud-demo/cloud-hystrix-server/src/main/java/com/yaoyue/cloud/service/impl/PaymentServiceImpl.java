package com.yaoyue.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yaoyue.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 王东旭
 * @createTime 2022/3/25 17:08
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Override
    public String paymentInfoOK(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "，调用成功，id：" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentInfoFailHandler", commandProperties = { // 设置超时调用方法
            // 设置服务自身超时调用时间，如果调用时间在自身超时时间内，正常处理，超出，则调用超时方法进行服务降级
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoFail(Long id) {
        try {
            // 程序出错，引导服务降级
//            int i = 10 / 0;
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "，调用失败，id：" + id;
    }

    public String getPaymentInfoFailHandler(Long id) {
        return "生产者端：" + "线程池：" + Thread.currentThread().getName() + "服务超时或失败，请10s后重试，id：" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求总数阈值，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 休眠时间窗口期（休眠多久进入半开模式），单位：毫秒，默认5000
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 请求次数错误率跳闸阈值，单位%，默认50
    })
    public String paymentCircuitBreaker(Long id) {
        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        return Thread.currentThread().getName() + "\t调用成功，流水号" + UUID.randomUUID();
    }

    public String paymentCircuitBreakerFallBack(Long id) {
        return "id不能为负数，id：" + id;
    }
}
