package com.yaoyue.cloud.service;

/**
 * @Author 王东旭
 * @CreateTime 2022/3/25 17:10
 * @Description
 */
public interface PaymentService {

    /**
     * 正确调用
     * @param id
     * @return
     */
    String paymentInfoOK(Long id);

    /**
     * 失败调用
     * @param id
     * @return
     */
    String paymentInfoFail(Long id);

    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Long id);
}
