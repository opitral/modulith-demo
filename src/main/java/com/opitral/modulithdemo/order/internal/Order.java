package com.opitral.modulithdemo.order.internal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int productId;

    @Positive
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { NEW, PAID }
}