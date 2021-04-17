package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseEntity{
    private String name;
    private String description;
    private Integer qty;
    private Integer price;
    private String unit;
    private Integer lowLimitAlert;
    private Integer tax;
    private Boolean enabled;
    @ManyToOne(fetch = FetchType.LAZY)
private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
@OneToOne(mappedBy = "product")
    private InvoiceProduct invoiceProduct;







}
