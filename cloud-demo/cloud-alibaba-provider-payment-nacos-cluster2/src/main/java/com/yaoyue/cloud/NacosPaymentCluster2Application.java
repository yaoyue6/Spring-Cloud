package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王东旭
 * @createTime 2022/4/10 23:07
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPaymentCluster2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentCluster2Application.class, args);
    }
}
