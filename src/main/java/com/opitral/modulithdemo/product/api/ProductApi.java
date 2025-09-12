package com.opitral.modulithdemo.product.api;

import com.opitral.modulithdemo.product.internal.Product;

import java.util.List;

public interface ProductApi {
    List<Product> all();
    Product create(Product p);
    Product get(Integer id);
}