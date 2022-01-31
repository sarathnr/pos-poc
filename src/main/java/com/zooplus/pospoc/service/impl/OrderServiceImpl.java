package com.zooplus.pospoc.service.impl;

import com.zooplus.pospoc.dto.OrderRequest;
import com.zooplus.pospoc.entity.Order;
import com.zooplus.pospoc.repository.OrderRepository;
import com.zooplus.pospoc.service.CustomerService;
import com.zooplus.pospoc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    private final ModelMapper mapper;

    public Order createOrder(OrderRequest orderRequest) {

        Order mappedOrder = mapper.map(orderRequest, Order.class);
        mappedOrder.setOrderTotal(orderRequest.getOrderAmount());

        Order savedOrder = orderRepository.save(mappedOrder);
        savedOrder.setOrderBalance(orderRequest.getOrderAmount().negate());
        customerService.updateCustomerBalanceAfterOrder(savedOrder);

        return savedOrder;
    }

}
