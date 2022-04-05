package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王东旭
 * @createTime 2022/3/20 17:48
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication.class, args);
    }
}
