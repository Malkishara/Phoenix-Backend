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
import java.util.Optional;
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
                 log.info(String.valueOf(jobSeekerDto.getCv().length()));

        if(jobSeekerDto.getPassword().equals(jobSeekerDto.getConfirmPassword()) && foundJobSeeker.size()==0 && foundEmployer.size()==0) {
            JobSeeker jobSeeker = new JobSeeker(
                    jobSeekerDto.getId(),
                    jobSeekerDto.getFirstName(),
                    jobSeekerDto.getLastName(),
                    jobSeekerDto.getPhone(),
                    jobSeekerDto.getEmail(),
                    jobSeekerDto.getCv(),
                    jobSeekerDto.getPassword(),
                    jobSeekerDto.getProfilePicture(),
                    jobSeekerDto.getDistrict(),
                    jobSeekerDto.getCountry(),
                    jobSeekerDto.getCollege(),
                    jobSeekerDto.getDegree(),
                    jobSeekerDto.getCertification(),
                    jobSeekerDto.getSkills(),
                    jobSeekerDto.getLanguages(),
                    jobSeekerDto.getPosition(),
                    jobSeekerDto.getExperience(),
                    jobSeekerDto.getLinkdin(),
                    jobSeekerDto.getCertificate()

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


    @Override
    public Boolean updateJobSeeker(JobSeeker jobSeeker) {

        log.info(String.valueOf(jobSeeker.getId()));
        log.info(getJobseekerById(jobSeeker.getId()).get().getPassword());
        jobSeeker.setPassword(getJobseekerById(jobSeeker.getId()).get().getPassword());
        jobSeekerRepository.save(jobSeeker);
        return true;
    }

    @Override
    public Optional<JobSeeker> getJobseekerById(Integer id) {

        return jobSeekerRepository.findById(id);
    }
}
