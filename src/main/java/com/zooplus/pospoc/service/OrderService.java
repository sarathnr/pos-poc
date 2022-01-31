package com.zooplus.pospoc.service;

import com.zooplus.pospoc.dto.OrderRequest;
import com.zooplus.pospoc.entity.Order;
import org.springframework.stereotype.Service;


@Service
public interface OrderService {

   Order createOrder(OrderRequest order);
}
