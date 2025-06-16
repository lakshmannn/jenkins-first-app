package com.product.service;

import com.product.entiry.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    public Flux<Product> findAll() {
        return repository.findAll();
    }

    public Mono<Product> findById(Integer id) {
        return repository.findById(id);
    }
}
