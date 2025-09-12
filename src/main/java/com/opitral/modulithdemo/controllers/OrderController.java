package com.opitral.modulithdemo.controllers;

import com.opitral.modulithdemo.models.Order;
import com.opitral.modulithdemo.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping
    public List<Order> all() { return service.findAll(); }

    @PostMapping
    public Order place(@RequestBody PlaceOrderRequest r) {
        return service.place(r.productId(), r.quantity());
    }
}