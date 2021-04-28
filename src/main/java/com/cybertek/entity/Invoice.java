package com.cybertek.entity;

import com.cybertek.enums.InvoiceStatus;
import com.cybertek.enums.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice extends BaseEntity{
    private String invoiceNo;
    @Enumerated(value = EnumType.STRING)
    private InvoiceStatus invoiceStatus;
    private Integer invoiceNum;
    @Enumerated(value = EnumType.STRING)
    private InvoiceType invoiceType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;
    private Boolean enabled;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @OneToOne(fetch = FetchType.LAZY)
    private Sp sp;
    @OneToOne(mappedBy = "invoice")
    private InvoiceProduct invoiceProduct;





}
