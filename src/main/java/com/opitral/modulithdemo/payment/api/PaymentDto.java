package com.opitral.modulithdemo.payment.api;

public record PaymentDto(
        Integer id,
        int orderId,
        double amount,
        Status status
) {
    public enum Status { CREATED, CONFIRMED }
}