package com.zooplus.pospoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.pospoc.dto.OrderRequest;
import com.zooplus.pospoc.dto.OrderResponse;
import com.zooplus.pospoc.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;
    OrderRequest orderRequest;
    OrderResponse orderResponse;

    @MockBean
    private OrderService orderService;

    @MockBean
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        this.orderRequest = new OrderRequest();
        orderRequest.setOrderAmount(BigDecimal.TEN);
        orderRequest.setCurrencyOpted("EUR");

        this.orderResponse = new OrderResponse();
        orderResponse.setOrderId(1L);
        orderResponse.setOrderTotal(BigDecimal.TEN);
        orderResponse.setCurrencyOpted("EUR");
        orderResponse.setOrderBalance(BigDecimal.TEN);
        orderResponse.setCustomerBalance(BigDecimal.TEN);
    }

    @Test
    void add() throws Exception {

        MvcResult result = this.mockMvc.perform(put("/api/v1/order/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(orderRequest)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();
        assertNotNull(result);
    }

    private String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
