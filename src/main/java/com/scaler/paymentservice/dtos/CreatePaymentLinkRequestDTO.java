package com.scaler.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkRequestDTO {
    private String orderId;
}