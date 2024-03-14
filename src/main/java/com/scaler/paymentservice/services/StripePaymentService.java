package com.scaler.paymentservice.services;

import org.springframework.stereotype.Service;


@Service
public class StripePaymentService implements PaymentService{
    // talks to the Stripe Payment Gateway,
    // and gets all the payment related fn done.

    @Override
    public String createPaymentLink(String orderId) {
        return null;
    }

    @Override
    public String getStatus(String orderId) {
        return null;
    }

}
