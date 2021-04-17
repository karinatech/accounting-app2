package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.InvoiceDTO;
import com.cybertek.entity.Invoice;
import com.cybertek.enums.InvoiceStatus;
import com.cybertek.enums.InvoiceType;
import com.cybertek.repo.InvoiceRepo;
import com.cybertek.service.InvoiceService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.InlineView;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepo invoiceRepo;
    private MapperUtil mapperUtil;

    public InvoiceServiceImpl(InvoiceRepo invoiceRepo, MapperUtil mapperUtil) {
        this.invoiceRepo = invoiceRepo;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public Invoice save(InvoiceDTO invoiceDTO) {
        Invoice invoice=mapperUtil.convert(invoiceDTO,new Invoice());
        invoice.setInvoiceStatus(InvoiceStatus.IN_PROCESS);
        invoiceRepo.save(invoice);
        return invoice;
    }

    @Override
    public InvoiceDTO findInvoiceByInvoiceNumber(Integer invoiceNumber) {
        Invoice invoice=invoiceRepo.findInvoiceByInvoiceNum(invoiceNumber);
        return mapperUtil.convert(invoice,new InvoiceDTO());
    }

    @Override
    public List<InvoiceDTO> listAllSaleInvoices() {
        List<Invoice>invoices=invoiceRepo.findInvoicesByInvoiceType(InvoiceType.SALE);
        return invoices.stream().map(obj->{return mapperUtil.convert(obj,new InvoiceDTO());})
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> listAllPurchaseInvoices() {
        List<Invoice>invoices=invoiceRepo.findInvoicesByInvoiceType(InvoiceType.PURCHASE);
        return invoices.stream().map(obj->{return mapperUtil.convert(obj,new InvoiceDTO());})
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> listAllOutstandingInvoices() {
        List<Invoice>invoices=invoiceRepo.findInvoicesByInvoiceStatus(InvoiceStatus.REJECTED);
        return invoices.stream().map(obj->{return mapperUtil.convert(obj,new InvoiceDTO());})
                .collect(Collectors.toList());
    }
}
