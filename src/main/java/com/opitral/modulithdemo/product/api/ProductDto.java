package com.opitral.modulithdemo.product.api;

public record ProductDto(
        Integer id,
        String name,
        double price
) {}