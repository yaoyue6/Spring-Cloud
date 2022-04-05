package com.yaoyue.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.yaoyue.cloud.entity.Payment;
import com.yaoyue.cloud.entity.Result;
import com.yaoyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

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
        log.info("端口号：" + port);
        if(payment != null) {
            return Result.success(JSON.toJSONString(payment));
        } else {
            return Result.fail();
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for(String service : services) {
            log.info("服务信息：" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance : instances) {
            log.info("实例信息：\t实例id：" + instance.getInstanceId() + "\t主机名：" + instance.getHost() + "\t端口号：" + instance.getPort() + "\t服务id：" + instance.getServiceId() + "\tURI地址：" + instance.getUri());
        }
        return discoveryClient;
    }
}
