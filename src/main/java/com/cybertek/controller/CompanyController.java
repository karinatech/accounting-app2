package com.cybertek.controller;

import com.cybertek.dto.CompanyDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create-company")
    public ResponseEntity<ResponseWrapper> companyCreate(@RequestBody CompanyDTO companyDTO){
CompanyDTO createdCompany = companyService.save(companyDTO);
        return ResponseEntity.ok(new ResponseWrapper("User Has been created",createdCompany));
    }
}
