package com.opitral.modulithdemo.order.internal;

import com.opitral.modulithdemo.order.api.OrderDto;
import com.opitral.modulithdemo.payment.api.PaymentApi;
import com.opitral.modulithdemo.payment.api.PaymentDto;
import com.opitral.modulithdemo.order.api.OrderApi;
import com.opitral.modulithdemo.product.api.ProductApi;
import com.opitral.modulithdemo.product.api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrderService implements OrderApi {
    private final OrderRepository orderRepo;
    private final ProductApi productApi;
    private final PaymentApi paymentApi;

    public List<OrderDto> all() {
        return orderRepo.findAll().stream().map(OrderService::toDto).toList();
    }

    @Transactional
    public OrderDto place(Integer productId, int qty) {
        ProductDto p = productApi.get(productId);
        Order o = Order.builder().productId(p.id()).quantity(qty).status(Order.Status.NEW).build();
        o = orderRepo.save(o);
        double amount = p.price() * qty;
        paymentApi.save(new PaymentDto(null, o.getId(), amount, PaymentDto.Status.CREATED));
        return toDto(o);
    }

    public static OrderDto toDto(Order o) {
        return new OrderDto(o.getId(), o.getProductId(), o.getQuantity(), o.getStatus().toString());
    }


}