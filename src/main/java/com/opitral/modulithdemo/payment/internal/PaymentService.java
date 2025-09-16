package com.opitral.modulithdemo.payment.internal;

import com.opitral.modulithdemo.payment.api.PaymentApi;
import com.opitral.modulithdemo.payment.api.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PaymentService implements PaymentApi {
    private final PaymentRepository repo;
    public List<PaymentDto> all() {
        return repo.findAll().stream().map(PaymentService::toDto).toList();
    }
    public PaymentDto save(PaymentDto p) {
        return toDto(repo.save(fromDto(p)));
    }
    public static PaymentDto toDto(Payment p) { return new PaymentDto(p.getId(), p.getOrderId(), p.getAmount(), PaymentDto.Status.valueOf(p.getStatus().toString())); }
    public static Payment fromDto(PaymentDto p) { return new Payment(p.id(), p.orderId(), p.amount(), Payment.Status.valueOf(p.status().name())); }
}