package com.scaler.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    public void saveEvent(Object webhookEvent){
        // save the orderId to DB with the status
        // you got in the event
    }
}
