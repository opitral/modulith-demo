package com.opitral.modulithdemo.payment.internal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int orderId;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { CREATED, CONFIRMED }
}