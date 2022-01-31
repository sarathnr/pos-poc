package com.zooplus.pospoc.controller;


import com.zooplus.pospoc.dto.PaymentRequest;
import com.zooplus.pospoc.dto.PaymentResponse;
import com.zooplus.pospoc.entity.Customer;
import com.zooplus.pospoc.entity.Payment;
import com.zooplus.pospoc.service.CustomerService;
import com.zooplus.pospoc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentService paymentService;
    private final CustomerService customerService;
    private final ModelMapper mapper;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponse> payment(@RequestBody PaymentRequest paymentRequest) {

        LOGGER.info("Order Payment in progress");
        try {
            Payment payment = paymentService.register(paymentRequest);

            payment.getOrder().setOrderBalance(payment.getAmount().subtract(payment.getOrder().getOrderTotal()));
            Customer updatedCustomer = customerService.updateCustomerBalancePostPayment(payment);

            PaymentResponse paymentResponse = mapper.map(payment, PaymentResponse.class);
            paymentResponse.setCustomerBalance(updatedCustomer.getBalance());
            paymentResponse.setAmountPaid(paymentRequest.getAmount());

            LOGGER.info("Order Payment registered");
            return ResponseEntity.ok(paymentResponse);

        } catch (Exception ex) {
           LOGGER.error(ex.getMessage());
        }
        return null;
    }
}
