package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王东旭
 * @createTime 2022/3/20 21:30
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication.class, args);
    }
}
