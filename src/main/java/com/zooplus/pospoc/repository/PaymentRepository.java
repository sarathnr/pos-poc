package com.zooplus.pospoc.repository;

import com.zooplus.pospoc.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Payment save(Payment payment);
}