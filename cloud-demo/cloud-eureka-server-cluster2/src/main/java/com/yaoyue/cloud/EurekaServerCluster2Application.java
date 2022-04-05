package com.yaoyue.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 王东旭
 * @createTime 2022/3/17 21:25
 * @description
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCluster2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCluster2Application.class, args);
    }
}
