package com.customer.service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
        private final CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public Mono<Customer> save(Customer customer) {
            return repository.save(customer);
        }

        public Flux<Customer> findAll() {
            return repository.findAll();
        }

        public Mono<Customer> findById(Integer id) {
            return repository.findById(id);
        }
}
