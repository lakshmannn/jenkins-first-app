package com.order.controller;

import com.order.entity.CustomerOrder;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping
    public Mono<ResponseEntity<CustomerOrder>> placeOrder(@RequestBody CustomerOrder order) {
        return service.placeOrder(order)
                .map(o -> ResponseEntity.status(HttpStatus.CREATED).body(o));
    }

    @GetMapping
    public Flux<CustomerOrder> all() {
        Flux<CustomerOrder>  list =  service.all();
        list.doOnNext(order -> System.out.println("Fetched order: "+order));
        return list;
    }
}
