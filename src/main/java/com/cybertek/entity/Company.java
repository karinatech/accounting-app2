package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends BaseEntity {
    private String title;
    private String address1;
    private String address2;
    private String state;
    private String zip;
    private String representative;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishedDate;
    private Boolean enabled;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Product>products;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "company")
    private List<Invoice>invoices;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "company")
    private Sp sp;
    @OneToMany(mappedBy = "company")
    private List<User>users;
    @OneToOne(mappedBy = "company")
    private InvoiceNumber invoiceNumber;






}
