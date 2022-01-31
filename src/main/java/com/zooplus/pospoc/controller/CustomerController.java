package com.zooplus.pospoc.controller;

import com.zooplus.pospoc.dto.CustomerRequest;
import com.zooplus.pospoc.dto.CustomerResponse;
import com.zooplus.pospoc.entity.Customer;
import com.zooplus.pospoc.service.CustomerService;
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
@RequestMapping(value = "/api/v1/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final ModelMapper mapper;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest) {

        LOGGER.info("Customer signup in progress");
        Customer customer = customerService.addCustomer(customerRequest);
        LOGGER.info("Customer created");
        return ResponseEntity.ok(mapper.map(customer, CustomerResponse.class));
    }
}
