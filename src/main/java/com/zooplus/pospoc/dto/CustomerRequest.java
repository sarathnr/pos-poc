package com.zooplus.pospoc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerRequest {

    private String name;
    private String email;
    private BigDecimal balance;
}
