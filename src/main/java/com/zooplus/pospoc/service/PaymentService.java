package com.zooplus.pospoc.service;

import com.zooplus.pospoc.dto.PaymentRequest;
import com.zooplus.pospoc.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Payment register(PaymentRequest paymentRequest);
}
