package com.product.controller;

import com.product.entiry.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public Mono<Product> create(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping
    public Flux<Product> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> byId(@PathVariable Integer id) {
        return service.findById(id);
    }
}
