package com.opitral.modulithdemo.payment.internal;

import com.opitral.modulithdemo.payment.api.PaymentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PaymentService implements PaymentApi {
    private final PaymentRepository repo;
    public List<Payment> all() { return repo.findAll(); }
    public Payment save(Payment p) { return repo.save(p); }
}