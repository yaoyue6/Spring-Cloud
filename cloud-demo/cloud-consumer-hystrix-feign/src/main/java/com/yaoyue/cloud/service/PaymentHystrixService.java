package com.yaoyue.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 王东旭
 * @createTime 2022/3/27 19:20
 * @description
 */
@Component
public class PaymentHystrixService implements PaymentService {

    @Override
    public String getPaymentInfoOk(Long id) {
        return "消费端：getPaymentInfoOk，" + Thread.currentThread().getName();
    }

    @Override
    public String getPaymentInfoFail(Long id) {
        return "消费端：getPaymentInfoFail，" + Thread.currentThread().getName();
    }
}
