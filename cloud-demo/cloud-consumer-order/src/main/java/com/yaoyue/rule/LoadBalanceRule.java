package com.yaoyue.rule;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王东旭
 * @createTime 2022/3/21 21:24
 * @description 不能放在启动类所在的包及其子包下，不然无法进行特殊化配置
 */
@Configuration
public class LoadBalanceRule {

//    @Bean
//    public IRule getRule() {
//        return new RandomRule();
//    }
}
