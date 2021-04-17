package com.cybertek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {
    private Integer id;
    private String invoiceNo;
    private String invoiceStatus;
    private Integer invoiceNum;
    private String invoiceType;
    private LocalDate invoiceDate;
    private Boolean enabled;
}
