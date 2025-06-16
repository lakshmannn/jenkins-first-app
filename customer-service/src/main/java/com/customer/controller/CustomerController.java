package com.customer.controller;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @GetMapping
    public Flux<Customer> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> byId(@PathVariable Integer id) {
        return service.findById(id);
    }
}
