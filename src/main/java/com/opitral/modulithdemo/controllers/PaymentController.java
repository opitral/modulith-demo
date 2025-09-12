package com.opitral.modulithdemo.controllers;

import com.opitral.modulithdemo.models.Payment;
import com.opitral.modulithdemo.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;
    @GetMapping
    public List<Payment> all() { return service.findAll(); }
}