package com.opitral.modulithdemo.payment.api;

import com.opitral.modulithdemo.payment.internal.Payment;

import java.util.List;

public interface PaymentApi {
    List<Payment> all();
    Payment save(Payment p);
}