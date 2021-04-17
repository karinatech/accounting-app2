package com.cybertek.service;

import com.cybertek.dto.InvoiceDTO;
import com.cybertek.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice save(InvoiceDTO invoiceDTO);
    InvoiceDTO findInvoiceByInvoiceNumber(Integer invoiceNumber);
    List<InvoiceDTO>listAllSaleInvoices();
    List<InvoiceDTO>listAllPurchaseInvoices();
    List<InvoiceDTO>listAllOutstandingInvoices();


}
