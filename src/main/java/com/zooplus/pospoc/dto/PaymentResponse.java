package com.zooplus.pospoc.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponse {

    private Long paymentId;
    private BigDecimal orderTotal;
    private BigDecimal orderBalance;
    private BigDecimal customerBalance;
    private BigDecimal amountPaid;

}
