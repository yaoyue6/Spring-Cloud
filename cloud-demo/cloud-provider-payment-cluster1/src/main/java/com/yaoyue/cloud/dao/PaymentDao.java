package com.yaoyue.cloud.dao;

import com.yaoyue.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 王东旭
 * @createTime 2022/3/15 9:50
 * @description
 */
@Mapper
public interface PaymentDao {

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
    Payment getPaymentById(@Param("id") Long id);
}
