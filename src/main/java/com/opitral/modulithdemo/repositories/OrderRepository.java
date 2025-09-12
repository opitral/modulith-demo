package com.opitral.modulithdemo.repositories;

import com.opitral.modulithdemo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}