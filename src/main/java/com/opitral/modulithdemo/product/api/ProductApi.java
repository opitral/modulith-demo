package com.opitral.modulithdemo.product.api;

import java.util.List;

public interface ProductApi {
    List<ProductDto> all();
    ProductDto create(ProductDto p);
    ProductDto get(Integer id);
}