package com.yaoyue.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.entity.Result;
import com.yaoyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 王东旭
 * @createTime 2022/3/15 10:26
 * @description
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping(value = "/payment/insert/")
    public Result savePayment(@RequestBody Payment payment) {
        int result = paymentService.savePayment(payment);
        log.info("插入结果：" + result);
        if(result > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    @GetMapping(value = "/payment/select/{id}")
    public Result getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        log.info("查询数据：" + payment);
        if(payment != null) {
            return Result.success(JSON.toJSONString(payment));
        } else {
            return Result.fail();
        }
    }
}
