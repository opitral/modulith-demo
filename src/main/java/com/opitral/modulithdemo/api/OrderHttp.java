package com.opitral.modulithdemo.api;

import com.opitral.modulithdemo.order.internal.Order;
import com.opitral.modulithdemo.order.api.OrderApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderHttp {
    private final OrderApi orderApi;
    @GetMapping public List<Order> all() { return orderApi.all(); }
    @PostMapping public Order place(@RequestBody PlaceOrderRequest r) {
        try {
            return orderApi.place(r.productId(), r.quantity());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}