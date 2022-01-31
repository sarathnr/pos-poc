package com.zooplus.pospoc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.pospoc.dto.CustomerRequest;
import com.zooplus.pospoc.dto.CustomerResponse;
import com.zooplus.pospoc.service.CustomerService;
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

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {


    @Autowired
    MockMvc mockMvc;
    CustomerRequest customerRequest;
    CustomerResponse customerResponse;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        this.customerRequest = new CustomerRequest();
        customerRequest.setEmail("kat@gmail.com");
        customerRequest.setName("kat");

        this.customerResponse = new CustomerResponse();
        customerResponse.setEmail("kat@gmail.com");
        customerResponse.setName("kat");
        customerResponse.setBalance(BigDecimal.ZERO);
    }

    @Test
    void addCustomer() throws Exception {
        MvcResult result = this.mockMvc.perform(post("/api/v1/customer/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(customerRequest)))
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
