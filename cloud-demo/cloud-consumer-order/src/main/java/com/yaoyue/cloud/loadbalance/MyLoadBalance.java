package com.yaoyue.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 王东旭
 * @createTime 2022/3/22 12:06
 * @description
 */
public class MyLoadBalance implements LoadBalancer {

    private AtomicInteger index = new AtomicInteger(0);

    /**
     * 进行累加操作
     * @return
     */
    public final int getAndIncrement() {
        int next;
        int current;

        do {
            current = index.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.index.compareAndSet(current, next));

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
