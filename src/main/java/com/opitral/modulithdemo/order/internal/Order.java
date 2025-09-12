package com.opitral.modulithdemo.order.internal;

import com.opitral.modulithdemo.product.internal.Product;
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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Product product;

    @Positive
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { NEW, PAID }
}