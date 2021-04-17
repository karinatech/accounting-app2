package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InvoiceProduct extends BaseEntity {
    private BigDecimal unitPrice;
    private Integer qty;

    @OneToOne
    private Product product;

    @OneToOne
    private Invoice invoice;



}
