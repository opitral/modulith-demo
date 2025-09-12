package com.opitral.modulithdemo.models;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    private Order orderRef;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { CREATED, CONFIRMED }
}