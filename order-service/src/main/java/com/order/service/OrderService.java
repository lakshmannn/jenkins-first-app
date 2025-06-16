package com.order.service;

import com.order.entity.CustomerOrder;
import com.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;
    @Autowired
    private WebClient customerClient;
    @Autowired
    private WebClient productClient;

    public Mono<CustomerOrder> placeOrder(CustomerOrder order) {
        return customerClient.get().uri("/customers/{id}", order.getCustomerId())
                .retrieve().bodyToMono(Void.class)  // just to validate existence
                .then(productClient.get().uri("/products/{id}", order.getProductId())
                        .retrieve().bodyToMono(Void.class))
                .then(Mono.defer(() -> {
                    order.setOrderDate(LocalDateTime.now());
                    order.setStatus("CREATED");
                    return repo.save(order);
                }));
    }

    public Flux<CustomerOrder> all() {
        return repo.findAll();
    }
}
