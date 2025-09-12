package com.opitral.modulithdemo.services;

import com.opitral.modulithdemo.models.Product;
import com.opitral.modulithdemo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;
    public List<Product> findAll() { return repo.findAll(); }
    public Product create(Product p) { return repo.save(p); }
    public Product get(Integer id) { return repo.findById(id).orElseThrow(); }
}