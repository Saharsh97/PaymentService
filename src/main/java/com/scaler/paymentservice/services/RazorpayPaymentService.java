package com.scaler.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentService implements PaymentService{
    // talks to the Razorpay Payment Gateway,
    // and gets all the payment related fn done.


    // I want to talk to Razorpay
    // I want to use some libraries to achieve this.

    private RazorpayClient razorpayClient;

    @Autowired
    public RazorpayPaymentService(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }
    // this client communicates with the PaymentGateway

    @Override
    public String createPaymentLink(String orderId) throws Exception {
        JSONObject paymentLinkRequest = new JSONObject();
        // Computers are not good with decimals
        // computers dont store the exact value of a decimal.
        // computers stores approximations for decimals.
        // Real amount = 10.01
        // Real amount = 99.99
        // Real amount = 150.33
        // give the value as RealAmount * 100.
        paymentLinkRequest.put("amount", 1001);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
//        paymentLinkRequest.put("first_min_partial_amount",500);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + (15 * 60 * 1000));
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for Order Id #" + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name","+917827569029");
        customer.put("contact","Saharsh Singh");
        customer.put("email","saharsh.singh_1@scaler.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("payment for Iphone","IPhone 15");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://google.com");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url");
    }

    @Override
    public String getStatus(String orderId) {
        // go to your DB and check if you already have
        // an entry for this orderId
        // if not:
        //      response = razorpayClient.getStatus()
        //      update the DB with this orderId and response
        // return db.get(orderId)
        return null;
    }


}
