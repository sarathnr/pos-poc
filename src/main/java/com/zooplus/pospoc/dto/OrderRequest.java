package com.zooplus.pospoc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

    private Long customerId;
    private String currencyOpted;
    private BigDecimal orderAmount;

}
