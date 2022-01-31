package com.zooplus.pospoc.service.impl;

import com.zooplus.pospoc.dto.PaymentRequest;
import com.zooplus.pospoc.entity.Payment;
import com.zooplus.pospoc.repository.CustomerRepository;
import com.zooplus.pospoc.repository.PaymentRepository;
import com.zooplus.pospoc.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    public final PaymentRepository paymentRepository;
    public final CustomerRepository customerRepository;
    private final ModelMapper mapper;


    @Override
    public Payment register(PaymentRequest paymentRequest) {

       Payment payment = mapper.map(paymentRequest, Payment.class);
       return paymentRepository.save(payment);

    }


}
