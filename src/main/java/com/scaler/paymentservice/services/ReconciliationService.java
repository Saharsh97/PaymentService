package com.scaler.paymentservice.services;

import com.razorpay.RazorpayClient;
import org.springframework.scheduling.annotation.Scheduled;

public class ReconciliationService {

    private RazorpayClient razorpayClient;

    public ReconciliationService(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    // this method should every 6hrs
    @Scheduled(cron = "30 1 1,15 8 *")
    public void doReconciliation(){
        // 1. I will use razorpayClient, and get the List<Transaction>
        // 2. get all my DB entries.
        // 3. I will check, every entry in DB
        // against corresponding entry in the list
        // if any mismatch:
        //      initiateRefunds()
    }

    // with cron jobs, you can achieve
    // anything that requires scheduling!
    // 1. reconciliation
    // 2. db verification for corrupt entries

}
