package com.zooplus.pospoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_TBL")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID", unique = true)
    private Long id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    private String currency;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
