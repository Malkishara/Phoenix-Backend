package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.Companies;
import com.oxcentra.phoenix.repository.CompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniesServiceImpl implements CompaniesService{

    @Autowired
    private CompaniesRepository companiesRepository;

    public List<Companies> getAllCompanies(){
        return companiesRepository.findAll();
    }
}
