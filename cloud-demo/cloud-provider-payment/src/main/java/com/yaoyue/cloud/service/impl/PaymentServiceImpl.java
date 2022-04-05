package com.yaoyue.cloud.service.impl;

import com.yaoyue.cloud.dao.PaymentDao;
import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/15 10:24
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
