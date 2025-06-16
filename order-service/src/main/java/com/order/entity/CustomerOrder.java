package com.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "userdb", name = "customer_order")
public class CustomerOrder {
    @Id
    private Long id;
    private Integer customerId;
    private Integer productId;
    private Integer amount;
    private LocalDateTime orderDate;
    private String status;
}
