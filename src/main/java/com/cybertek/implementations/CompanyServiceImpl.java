package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.CompanyDTO;
import com.cybertek.entity.Company;
import com.cybertek.repo.CompanyRepo;
import com.cybertek.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private MapperUtil mapperUtil;
    private CompanyRepo companyRepo;

    public CompanyServiceImpl(MapperUtil mapperUtil, CompanyRepo companyRepo) {
        this.mapperUtil = mapperUtil;
        this.companyRepo = companyRepo;
    }

    @Override
    public List<CompanyDTO> listAllCompanies() {
        List<Company>companyList=companyRepo.findAll();
        return companyList.stream().map(obj->{return mapperUtil.convert(obj,new CompanyDTO());})
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
      companyDTO.setEnabled(true);
      Company obj=mapperUtil.convert(companyDTO,new Company());
     Company company = companyRepo.save(obj);
        return mapperUtil.convert(company,new CompanyDTO());
    }

    @Override
    public void delete(Integer companyId) {
Optional <Company> company=  companyRepo.findById(companyId);
if(company.isPresent()) {
    company.get().setEnabled(false);
    company.get().setDeleted(true);
    companyRepo.save(company.get());
}
    }

    @Override
    public void disableCompany(Integer companyId) {
        Optional <Company> company=  companyRepo.findById(companyId);
        if(company.isPresent()) {
            company.get().setEnabled(false);
            companyRepo.save(company.get());
        }
    }
}
