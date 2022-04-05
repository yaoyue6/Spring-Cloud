package com.yaoyue.cloud.service;

import com.yaoyue.cloud.entity.Payment;


/**
 * @Author 王东旭
 * @CreateTime 2022/3/15 10:14
 * @Description
 */
public interface PaymentService {

    /**
     * 保存支付信息
     * @param payment
     * @return
     */
    int savePayment(Payment payment);

    /**
     * 获取支付信息
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
