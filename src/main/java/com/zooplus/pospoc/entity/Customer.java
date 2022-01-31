package com.zooplus.pospoc.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER_TBL")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String customerName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CUSTOMER_BALANCE")
    private BigDecimal balance;

}