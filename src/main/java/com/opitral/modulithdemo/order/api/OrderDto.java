package com.opitral.modulithdemo.order.api;

public record OrderDto(
        Integer id,
        Integer productId,
        int quantity,
        String status
) {}