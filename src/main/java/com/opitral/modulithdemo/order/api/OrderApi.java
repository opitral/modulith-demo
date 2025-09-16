package com.opitral.modulithdemo.order.api;

import java.util.List;

public interface OrderApi {
    List<OrderDto> all();
    OrderDto place(Integer productId, int quantity);
}