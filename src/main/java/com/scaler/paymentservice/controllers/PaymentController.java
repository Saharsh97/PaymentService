package com.scaler.paymentservice.controllers;

import com.scaler.paymentservice.dtos.CreatePaymentLinkRequestDTO;
import com.scaler.paymentservice.services.PaymentService;
import com.scaler.paymentservice.services.WebhookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;
    private WebhookService webhookService;
    public PaymentController(PaymentService paymentService, WebhookService webhookService){
        this.paymentService = paymentService;
        this.webhookService = webhookService;
    }

    @PostMapping()
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDTO requestDTO) throws Exception {
        return paymentService.createPaymentLink(requestDTO.getOrderId());
    }

    @GetMapping("/status/{order_id}")
    public String getStatus(@PathVariable("order_id") String orderId){
        return null;
    }

    @GetMapping("/callbackurl")
    public void callBackPage(){

    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Object webhookEvent){
        System.out.println("handling webhook event...");
        // call your own service
        webhookService.saveEvent(webhookEvent);
    }
}
