package com.opitral.modulithdemo.payment.api;

import java.util.List;

public interface PaymentApi {
    List<PaymentDto> all();
    PaymentDto save(PaymentDto p);
}