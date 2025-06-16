package com.order.repository;

import com.order.entity.CustomerOrder;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends R2dbcRepository<CustomerOrder,Long> {
}
