package com.liorlakhmann.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("sms-notification", r -> r.path("/api/notify/sms/**")
                        .uri("lb://sms-notification"))
                .route("email-notification", r -> r.path("/api/notify/email/**")
                        .uri("lb://email-notification"))
                .route("push-notification", r -> r.path("/api/notify/push/**")
                        .uri("lb://push-notification"))
                .build();
    }
}
