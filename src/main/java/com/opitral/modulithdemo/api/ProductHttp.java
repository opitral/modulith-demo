package com.opitral.modulithdemo.api;

import com.opitral.modulithdemo.product.api.ProductApi;
import com.opitral.modulithdemo.product.internal.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductHttp {
    private final ProductApi productApi;
    @GetMapping public List<Product> all() { return productApi.all(); }
    @PostMapping public Product create(@RequestBody @Validated Product p) { return productApi.create(p); }
    @GetMapping("/{id}") public Product get(@PathVariable Integer id) { return productApi.get(id); }
}