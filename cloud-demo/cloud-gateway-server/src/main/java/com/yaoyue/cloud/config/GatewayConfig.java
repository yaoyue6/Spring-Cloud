package com.yaoyue.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 王东旭
 * @createTime 2022/4/3 22:03
 * @description
 */
@Component
public class GatewayConfig {

    @Bean
    public RouteLocator buildRouteLocater1(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("payment_route2", r -> r.path("/").uri("http://www.baidu.com/")).build();
        return routes.build();
    }
}
