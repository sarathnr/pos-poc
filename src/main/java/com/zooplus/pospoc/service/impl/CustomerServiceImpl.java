package com.zooplus.pospoc.service.impl;

import com.zooplus.pospoc.dto.CustomerRequest;
import com.zooplus.pospoc.entity.Customer;
import com.zooplus.pospoc.entity.Order;
import com.zooplus.pospoc.entity.Payment;
import com.zooplus.pospoc.repository.CustomerRepository;
import com.zooplus.pospoc.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public Customer addCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(mapper.map(customerRequest, Customer.class));
    }

    public Customer updateCustomerBalancePostPayment(Payment payment) {
        Customer customer = payment.getOrder().getCustomer();
        customer.setBalance(payment.getAmount().subtract(payment.getOrder().getOrderTotal()));
        return customerRepository.save(customer);
    }

    public void updateCustomerBalanceAfterOrder(Order order) {

        Customer customer = order.getCustomer();
        if (customer.getBalance().compareTo(BigDecimal.ZERO) == 0) {
            customer.setBalance(order.getOrderTotal().negate());
        } else if (customer.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            customer.setBalance(order.getOrderTotal().subtract(customer.getBalance()).negate());
        } else {
            customer.setBalance(order.getOrderTotal().add(customer.getBalance().negate()).negate());
        }
        customerRepository.save(customer);
    }
}
