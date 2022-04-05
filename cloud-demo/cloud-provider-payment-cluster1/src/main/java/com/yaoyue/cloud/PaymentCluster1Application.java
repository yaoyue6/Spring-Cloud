package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 王东旭
 * @createTime 2022/3/14 22:40
 * @description
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentCluster1Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentCluster1Application.class, args);
    }
}
