package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.Companies;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.repository.JobSeekerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobSeekerServiceImpl implements JobSeekerService{
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private CompaniesService companiesService;

    public List<JobSeeker> getAllJobSeeker(){
        return jobSeekerRepository.findAll();
    }


    @Override
    public String addJobSeeker(JobSeekerDto jobSeekerDto) {
        String message;
        String val;
        List<JobSeeker> foundJobSeeker=new ArrayList<>();
        List<Companies> foundEmployer=new ArrayList<>();

        foundJobSeeker=getAllJobSeeker().stream().filter(s->
                jobSeekerDto.getEmail().contains(s.getEmail())).collect(Collectors.toList());

        foundEmployer=companiesService.getAllCompanies().stream().filter(c->
                jobSeekerDto.getEmail().contains(c.getEmail())).collect(Collectors.toList());


        log.info(String.valueOf(foundJobSeeker));


        if(jobSeekerDto.getPassword().equals(jobSeekerDto.getConfirmPassword()) && foundJobSeeker.size()==0 && foundEmployer.size()==0) {
            JobSeeker jobSeeker = new JobSeeker(
                    jobSeekerDto.getId(),
                    jobSeekerDto.getFirstName(),
                    jobSeekerDto.getLastName(),
                    jobSeekerDto.getPhoneNumber(),
                    jobSeekerDto.getEmail(),
                    jobSeekerDto.getCv(),
                    jobSeekerDto.getPassword()

            );

            jobSeekerRepository.save(jobSeeker);
            message=jobSeekerDto.getFirstName()+" saved";
            val="1";


        }else if(foundJobSeeker.size()>0 || foundEmployer.size()>0){
            log.info(String.valueOf(foundEmployer.size()));
            log.info(String.valueOf(foundJobSeeker.size()));
            message="Already registered email";
            val="2";
        }

        else{
            message="Confirmed password not matching with password";
            val="3";
        }
        log.info(message);
        return val;
    }
}
