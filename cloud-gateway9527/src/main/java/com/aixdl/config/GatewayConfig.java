package com.aixdl.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AIXDL
 * @description: TODO
 * @date 2023-07-17 22:47
 * @version: 1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        //设置路由映射 http://localhost:9527/guonei -> http://news.baidu.com/guonei
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_aixdl",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
