package com.zooplus.pospoc.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {

    private Long orderId;
    private BigDecimal orderTotal;
    private BigDecimal orderBalance;
    private BigDecimal customerBalance;
    private String customerId;
    private String currencyOpted;

}
