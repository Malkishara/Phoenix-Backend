package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.Companies;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.repository.CompaniesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CompaniesServiceImpl implements CompaniesService{

    @Autowired
    private CompaniesRepository companiesRepository;

    @Autowired
    private JobSeekerService jobSeekerService;

    public List<Companies> getAllCompanies(){
        return companiesRepository.findAll();
    }



}
