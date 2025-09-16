package com.opitral.modulithdemo.product.internal;

import com.opitral.modulithdemo.product.api.ProductApi;
import com.opitral.modulithdemo.product.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductService implements ProductApi {
    private final ProductRepository repo;
    public List<ProductDto> all() {
        return repo.findAll().stream().map(ProductService::toDto).toList();
    }
    public ProductDto create(ProductDto p) {
        return toDto(repo.save(fromDto(p)));
    }
    public ProductDto get(Integer id) {
        return toDto(repo.findById(id).orElseThrow(() -> new IllegalArgumentException("No product with id " + id)));
    }
    public static ProductDto toDto(Product p) { return new ProductDto(p.getId(), p.getName(), p.getPrice()); }
    public static Product fromDto(ProductDto p) { return new Product(p.id(), p.name(), p.price()); }
}