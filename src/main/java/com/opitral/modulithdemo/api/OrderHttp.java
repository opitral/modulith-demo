package com.opitral.modulithdemo.api;

import com.opitral.modulithdemo.order.internal.Order;
import com.opitral.modulithdemo.order.api.OrderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderHttp {
    private final OrderApi orderApi;
    @GetMapping public List<Order> all() { return orderApi.all(); }
    @PostMapping public Order place(@RequestBody PlaceOrderRequest r) { return orderApi.place(r.productId(), r.quantity()); }
}