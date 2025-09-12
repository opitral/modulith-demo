package com.opitral.modulithdemo.order.api;

import com.opitral.modulithdemo.order.internal.Order;

import java.util.List;

public interface OrderApi {
    List<Order> all();
    Order place(Integer productId, int quantity);
}