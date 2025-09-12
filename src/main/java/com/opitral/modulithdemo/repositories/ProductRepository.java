package com.opitral.modulithdemo.repositories;

import com.opitral.modulithdemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}