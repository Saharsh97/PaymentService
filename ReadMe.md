1. User -> OrderService
He will get the orderId
// This step is already done at the OrderService.


2. User -> PaymentService
He gives the orderId,
And he gets back a payment link.

Internally, my PaymentService will call the PaymentGateway
to get the link.

3. User goes to the Link, and does the payment.
Once it is done, I will be redirected to the CallbackUrl page

4. For any events at the PaymentGateway, I want a webhook to be hit.

5. Reconciliation. I will use a Cron Job for this.

APIs will I have in my service?
1. createPaymentLink(orderId)   // Implementing this today
2. getStatus(orderId)    // commented notes on the logic
3. handleWebhookEvent()

