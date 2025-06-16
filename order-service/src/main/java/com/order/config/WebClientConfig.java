package com.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient customerClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8082").build(); // customer-service
    }

    @Bean
    public WebClient productClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8083").build(); // product-service
    }
}
