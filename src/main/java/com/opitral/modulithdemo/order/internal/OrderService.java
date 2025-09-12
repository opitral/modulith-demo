package com.opitral.modulithdemo.order.internal;

import com.opitral.modulithdemo.payment.api.PaymentApi;
import com.opitral.modulithdemo.payment.internal.Payment;
import com.opitral.modulithdemo.order.api.OrderApi;
import com.opitral.modulithdemo.product.api.ProductApi;
import com.opitral.modulithdemo.product.internal.Product;
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

    public List<Order> all() { return orderRepo.findAll(); }

    @Transactional
    public Order place(Integer productId, int qty) {
        Product p = productApi.get(productId);
        Order o = Order.builder().product(p).quantity(qty).status(Order.Status.NEW).build();
        o = orderRepo.save(o);
        double amount = p.getPrice() * qty;
        paymentApi.save(Payment.builder().orderRef(o).amount(amount).status(Payment.Status.CREATED).build());
        return o;
    }
}