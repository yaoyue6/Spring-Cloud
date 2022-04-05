package com.yaoyue.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author 王东旭
 * @CreateTime 2022/3/22 12:05
 * @Description 手写轮询算法
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
