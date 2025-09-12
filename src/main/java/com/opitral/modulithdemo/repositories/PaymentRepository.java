package com.opitral.modulithdemo.repositories;

import com.opitral.modulithdemo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {}