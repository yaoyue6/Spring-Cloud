package com.yaoyue.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 王东旭
 * @createTime 2022/3/18 18:55
 * @description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yaoyue.cloud")
public class PaymentZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentZookeeperApplication.class, args);
    }
}
