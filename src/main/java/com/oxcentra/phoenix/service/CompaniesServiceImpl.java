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

//    @Override
//    public String addEmployer(EmployerDto employer) {
//      String message;
//      String val;
//
//        List<JobSeeker> foundJobSeeker=new ArrayList<>();
//        List<Companies> foundEmployer=new ArrayList<>();
//
//        foundEmployer=getAllCompanies().stream().filter(c->
//                employer.getEmail().contains(c.getEmail())).collect(Collectors.toList());
//
//        foundJobSeeker=jobSeekerService.getAllJobSeeker().stream().filter(s->
//                employer.getEmail().contains(s.getEmail())).collect(Collectors.toList());
//
//
//
//
//        log.info(String.valueOf(foundEmployer));
//
//        if(employer.getPassword().equals(employer.getConfirmPassword()) && foundEmployer.size()==0 && foundJobSeeker.size()==0) {
//            Employer employer1 = new Employer(
//                    employer.getId(),
//                    employer.getName(),
//                    employer.getAddress(),
//                    employer.getEmail(),
//                    employer.getPhone(),
//                    employer.getLogo(),
//                    employer.getPassword()
//
//            );
//
//            companiesRepository.save(employer1);
//       message=employer.getName()+" saved";
//
//       val="1";
//        }else if(foundJobSeeker.size()>0 || foundEmployer.size()>0){
//            message="Already registered email";
//            val="2";
//        }else{
//            message="Confirmed password not matching with password";
//            val="3";
//        }
//        log.info(message);
//        return val;
//    }


}
