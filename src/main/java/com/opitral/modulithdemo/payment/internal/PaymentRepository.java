package com.opitral.modulithdemo.payment.internal;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Integer> {}