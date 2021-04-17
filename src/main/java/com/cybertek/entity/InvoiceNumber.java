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
public class InvoiceNumber extends BaseEntity{

    @OneToOne
    private Company company;

    private Integer year;
    private Integer invoiceNumber;

}
