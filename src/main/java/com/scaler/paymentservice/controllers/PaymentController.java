package com.scaler.paymentservice.controllers;

import com.scaler.paymentservice.dtos.CreatePaymentLinkRequestDTO;
import com.scaler.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
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
    public void handleWebhookEvent(){
        System.out.println("handling webhook event...");
    }
}
