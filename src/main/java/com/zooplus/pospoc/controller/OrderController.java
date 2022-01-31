package com.zooplus.pospoc.controller;


import com.zooplus.pospoc.dto.OrderRequest;
import com.zooplus.pospoc.dto.OrderResponse;
import com.zooplus.pospoc.entity.Order;
import com.zooplus.pospoc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderService orderService;
    private final ModelMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @PutMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> addToCart(@RequestBody OrderRequest orderRequest) {

        LOGGER.info("Creating order");
        Order savedOrder = orderService.createOrder(orderRequest);
        OrderResponse orderResponse = mapper.map(savedOrder, OrderResponse.class);
        LOGGER.info("Order created {}", savedOrder);
        return ResponseEntity.ok(orderResponse);
    }
}