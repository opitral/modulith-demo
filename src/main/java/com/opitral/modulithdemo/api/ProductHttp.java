package com.opitral.modulithdemo.api;

import com.opitral.modulithdemo.product.api.ProductApi;
import com.opitral.modulithdemo.product.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductHttp {
    private final ProductApi productApi;
    @GetMapping public List<ProductDto> all() { return productApi.all(); }
    @PostMapping public ProductDto create(@RequestBody @Validated ProductDto p) { return productApi.create(p); }
    @GetMapping("/{id}") public ProductDto get(@PathVariable Integer id) { return productApi.get(id); }
}