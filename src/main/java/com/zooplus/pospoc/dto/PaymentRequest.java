package com.zooplus.pospoc.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private String currencyOpted;
    private BigDecimal amount;
    private Long orderId;

}
