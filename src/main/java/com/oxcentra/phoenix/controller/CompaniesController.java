package com.oxcentra.phoenix.controller;


import com.oxcentra.phoenix.model.Companies;
import com.oxcentra.phoenix.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/companies")
    public @ResponseBody List<Companies> getAllCompanies(){
        return companiesService.getAllCompanies();
    }

}
