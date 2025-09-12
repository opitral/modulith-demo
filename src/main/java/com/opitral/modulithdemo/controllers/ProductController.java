package com.opitral.modulithdemo.controllers;

import com.opitral.modulithdemo.models.Product;
import com.opitral.modulithdemo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> all() { return service.findAll(); }

    @PostMapping
    public Product create(@RequestBody @Validated Product p) { return service.create(p); }

    @GetMapping("/{id}")
    public Product get(@PathVariable Integer id) { return service.get(id); }
}