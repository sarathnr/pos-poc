package com.zooplus.pospoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.pospoc.dto.PaymentRequest;
import com.zooplus.pospoc.dto.PaymentResponse;
import com.zooplus.pospoc.service.CustomerService;
import com.zooplus.pospoc.service.PaymentService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PaymentController.class)
class PaymentControllerTest {

    @Autowired
    MockMvc mockMvc;
    PaymentRequest paymentRequest;
    PaymentResponse paymentResponse;
    @MockBean
    CustomerService customerService;
    @MockBean
    private PaymentService paymentService;
    @MockBean
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        this.paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(1L);
        paymentRequest.setAmount(BigDecimal.TEN);
        paymentRequest.setCurrencyOpted("EUR");

        this.paymentResponse = new PaymentResponse();
        paymentResponse.setAmountPaid(BigDecimal.TEN);
        paymentResponse.setCustomerBalance(BigDecimal.ZERO);
        paymentResponse.setOrderBalance(BigDecimal.ZERO);
        paymentResponse.setOrderTotal(BigDecimal.TEN);
    }

    @Test
    void register() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/api/v1/payment/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(paymentRequest)))
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
