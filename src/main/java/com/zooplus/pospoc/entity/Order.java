package com.zooplus.pospoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_TBL")
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @Column(name = "ORDER_TOTAL")
    private BigDecimal orderTotal;

    @Column(name = "CURRENCY_OPTED")
    private String currencyOpted;

    @Column(name = "ORDER_BALANCE")
    private BigDecimal orderBalance;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}