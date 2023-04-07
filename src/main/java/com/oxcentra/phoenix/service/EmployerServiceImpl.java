package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.Companies;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.repository.EmployerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployerServiceImpl implements EmployerService{

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobSeekerService jobSeekerService;

    public List<Employer> getAllEmployer(){
        return employerRepository.findAll();
    }

    @Override
    public String addEmployer(EmployerDto employer) {
        String message;
        String val;
              log.info(employer.getEmail());
        List<JobSeeker> foundJobSeeker=new ArrayList<>();
        List<Employer> foundEmployer=new ArrayList<>();

        foundEmployer=getAllEmployer().stream().filter(c->
                employer.getEmail().contains(c.getEmail())).collect(Collectors.toList());


        foundJobSeeker=jobSeekerService.getAllJobSeeker().stream().filter(s->
                employer.getEmail().contains(s.getEmail())).collect(Collectors.toList());




        log.info(String.valueOf(foundEmployer));
        employer.setVerification(false);

        if(employer.getPassword().equals(employer.getConfirmPassword()) && foundEmployer.size()==0 && foundJobSeeker.size()==0) {
            Employer employer1 = new Employer(
                    employer.getId(),
                    employer.getName(),
                    employer.getAddress(),
                    employer.getEmail(),
                    employer.getPhone(),
                    employer.getLogo(),
                    employer.getPassword(),
                    employer.getVerification()

            );

            employerRepository.save(employer1);
            message=employer.getName()+" saved";

            val="1";
        }else if(foundJobSeeker.size()>0 || foundEmployer.size()>0){
            message="Already registered email";
            val="2";
        }else{
            message="Confirmed password not matching with password";
            val="3";
        }
        log.info(message);
        return val;
    }

    @Override
    public Employer getEmployerById(int id) {
        Optional<Employer> employer=employerRepository.findById(id);


        if(employer.isPresent()){
            return employer.get();
        }
        throw new RuntimeException("employer not found");
    }

    @Override
    public Boolean updateEmployer(Employer employer) {
        log.info(String.valueOf(employer.getId()));
        log.info(getEmployerById(employer.getId()).getPassword());
        employer.setPassword(getEmployerById(employer.getId()).getPassword());
        employer.setVerification(getEmployerById(employer.getId()).getVerification());
        employerRepository.save(employer);
        return true;
    }

    @Override
    public Boolean updateEmployerVerification(Employer employer) {
        log.info(String.valueOf(employer.getId()));
        employer.setName(getEmployerById(employer.getId()).getName());
        employer.setEmail(getEmployerById(employer.getId()).getEmail());
        employer.setPassword(getEmployerById(employer.getId()).getPassword());
        employer.setAddress(getEmployerById(employer.getId()).getAddress());
        employer.setLogo(getEmployerById(employer.getId()).getLogo());
        employer.setPhone(getEmployerById(employer.getId()).getPhone());
        employerRepository.save(employer);
        return true;
    }
}
