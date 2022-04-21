package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 王东旭
 * @createTime 2022/4/14 22:13
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderApplication.class, args);
    }
}
