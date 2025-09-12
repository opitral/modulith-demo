package com.opitral.modulithdemo.services;

import com.opitral.modulithdemo.models.Payment;
import com.opitral.modulithdemo.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repo;
    public List<Payment> findAll() { return repo.findAll(); }
}