package com.opitral.modulithdemo.product.internal;

import com.opitral.modulithdemo.product.api.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductService implements ProductApi {
    private final ProductRepository repo;
    public List<Product> all() { return repo.findAll(); }
    public Product create(Product p) { return repo.save(p); }
    public Product get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("No product with id " + id));
    }
}