package com.cybertek.repo;

import com.cybertek.entity.Invoice;
import com.cybertek.enums.InvoiceStatus;
import com.cybertek.enums.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
    Invoice findInvoiceByInvoiceNum(Integer invoiceNum);
    List<Invoice> findInvoicesByInvoiceType(InvoiceType type);
    List<Invoice>findInvoicesByInvoiceStatus(InvoiceStatus status);
}
