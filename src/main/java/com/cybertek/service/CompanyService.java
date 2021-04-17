package com.cybertek.service;

import com.cybertek.dto.CompanyDTO;
import com.cybertek.entity.Company;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO>listAllCompanies();
    Company save(CompanyDTO companyDTO);
    void delete(Integer companyId);
    void disableCompany(Integer companyId);

}
