package com.opitral.modulithdemo.services;

import com.opitral.modulithdemo.models.Order;
import com.opitral.modulithdemo.models.Payment;
import com.opitral.modulithdemo.models.Product;
import com.opitral.modulithdemo.repositories.OrderRepository;
import com.opitral.modulithdemo.repositories.PaymentRepository;
import com.opitral.modulithdemo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    private final PaymentRepository paymentRepo;

    public List<Order> findAll() { return orderRepo.findAll(); }

    @Transactional
    public Order place(Integer productId, int qty) {
        Product p = productRepo.findById(productId).orElseThrow();
        Order o = Order.builder().product(p).quantity(qty).status(Order.Status.NEW).build();
        o = orderRepo.save(o);
        double amount = p.getPrice() * qty;
        paymentRepo.save(Payment.builder().orderRef(o).amount(amount).status(Payment.Status.CREATED).build());
        return o;
    }
}