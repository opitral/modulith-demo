package com.opitral.modulithdemo.api;

import com.opitral.modulithdemo.payment.api.PaymentApi;
import com.opitral.modulithdemo.payment.api.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentHttp {
    private final PaymentApi paymentApi;
    @GetMapping
    public List<PaymentDto> all() { return paymentApi.all(); }
}