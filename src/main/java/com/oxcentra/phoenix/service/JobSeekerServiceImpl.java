package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.*;
import com.oxcentra.phoenix.repository.JobSeekerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class JobSeekerServiceImpl implements JobSeekerService{
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private EmailService emailService;

    private int verificationCode;
    private JobSeeker jobSeeker1;

    public List<JobSeeker> getAllJobSeeker(){
        return jobSeekerRepository.findAll();
    }


    @Override
    public String addJobSeeker(JobSeekerDto jobSeeker) {
        log.info(jobSeeker.getEmail());
        String message;
        String val;
        int num=0;
        List<JobSeeker> foundJobSeeker=new ArrayList<>();
        List<Employer> foundEmployer=new ArrayList<>();
        List<Employer> allEmployers=employerService.getAllEmployer();
       jobSeeker1=new JobSeeker();

//            foundJobSeeker = getAllJobSeeker().stream().filter(s ->
//                    jobSeekerDto.getEmail().contains(s.getEmail())
//            ).collect(Collectors.toList());
//
//            foundEmployer = employerService.getAllEmployer().stream().filter(e ->
//                    jobSeekerDto.getEmail().contains(e.getEmail())
//            ).collect(Collectors.toList());

        for(int i=0;i<getAllJobSeeker().size();i++){
            if(jobSeeker.getEmail().equals(getAllJobSeeker().get(i).getEmail())){
                num++;
            }
        }

        for(int j=0;j<allEmployers.size();j++){
            if(jobSeeker.getEmail().equals(allEmployers.get(j).getEmail())){
                num++;
            }
        }

//        log.info(String.valueOf(foundJobSeeker.size()));
//        log.info(String.valueOf(foundEmployer.size()));
            jobSeeker1.setFirstName(jobSeeker.getFirstName());
        jobSeeker1.setLastName(jobSeeker.getLastName());
        jobSeeker1.setEmail(jobSeeker.getEmail());
        jobSeeker1.setPassword(jobSeeker.getPassword());
        jobSeeker1.setPhone(jobSeeker.getPhone());
        jobSeeker1.setCv(jobSeeker.getCv());

        if(jobSeeker.getPassword().equals(jobSeeker.getConfirmPassword()) && num==0) {

             log.info(String.valueOf(jobSeeker1));
            if(sendVerificationCode().equals(true)) {

                message ="Verification code sent";
                val = "1";
            }else{
                message =  " error";
                val = "4";
            }


        }else if(num>0){
//            log.info(String.valueOf(foundEmployer.size()));
//            log.info(String.valueOf(foundJobSeeker.size()));
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
    public Boolean sendVerificationCode(){
        log.info(jobSeeker1.getEmail());
        Random random = new Random();
        verificationCode = random.nextInt(90000000) + 10000000;
        String body="Verification code: "+verificationCode;
        String subject="Verification Code";
        if(emailService.sendEmail(jobSeeker1.getEmail(),body,subject).equals(true)){
            log.info("verification code sent");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updatePassword(int userId, String userEmail, String password) {
        String body="Your password Changed";
        String subject="Password Changed";



        JobSeeker jobSeeker=getJobseekerById(userId);
        jobSeeker.setPassword(password);
        jobSeekerRepository.save(jobSeeker);
        emailService.sendEmail(userEmail,body,subject);
        return true;
    }

    @Override
    public Boolean saveJobseeker() {
        String body="Congratulations!!! You have successfully registered with Phoenix.";
        String subject="Registration Successful";
        log.info("Job Seeker: "+jobSeeker1);
        jobSeekerRepository.save(jobSeeker1);
        emailService.sendEmail(jobSeeker1.getEmail(),body,subject);
        return true;
    }

    @Override
    public Boolean verifyUser(Integer code){
        log.info(String.valueOf(code));
        log.info(String.valueOf(verificationCode));
        if(code.equals(verificationCode)){
            log.info("job seeker saved");
            return saveJobseeker();
        }else{
            log.info("job seeker didn't saved");
            return false;
        }

    }
    @Override
    public Boolean updateJobSeeker(JobSeeker jobSeeker) {

        log.info(String.valueOf(jobSeeker.getId()));
        log.info(getJobseekerById(jobSeeker.getId()).getPassword());
        jobSeeker.setPassword(getJobseekerById(jobSeeker.getId()).getPassword());
        jobSeekerRepository.save(jobSeeker);
        return true;
    }

    @Override
    public JobSeeker getJobseekerById(Integer id) {

        Optional<JobSeeker> jobSeeker=jobSeekerRepository.findById(id);


        if(jobSeeker.isPresent()){
            return jobSeeker.get();
        }
        throw new RuntimeException("employer not found");
    }
}