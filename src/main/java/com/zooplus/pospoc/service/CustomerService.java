package com.zooplus.pospoc.service;

import com.zooplus.pospoc.dto.CustomerRequest;
import com.zooplus.pospoc.entity.Customer;
import com.zooplus.pospoc.entity.Order;
import com.zooplus.pospoc.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer addCustomer(CustomerRequest customerRequest);

    Customer updateCustomerBalancePostPayment(Payment payment);

    void updateCustomerBalanceAfterOrder(Order savedOrder);
}
