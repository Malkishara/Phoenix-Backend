package com.oxcentra.phoenix.common;

import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.service.EmailService;
import com.oxcentra.phoenix.service.EmployerService;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PasswordUtility {
    @Autowired
    private EmailService emailService;
    @Autowired
     private EmployerService employerService;
    @Autowired
     private JobSeekerService jobSeekerService;

    int verificationCode;
    String userEmail;
    String userType;
    int userId;

    public Boolean sendEmail(String email) {

        userEmail=email;
        List<JobSeeker> foundJobSeeker=new ArrayList<>();
        List<Employer> foundEmployer=new ArrayList<>();

                foundEmployer=employerService.getAllEmployer().stream().filter(c->
                email.contains(c.getEmail())).collect(Collectors.toList());


               foundJobSeeker = jobSeekerService.getAllJobSeeker().stream().filter(s->
                email.contains(s.getEmail())).collect(Collectors.toList());

               if(foundEmployer.size()>0 ){
                   userType="employer";
                   userId=foundEmployer.get(0).getId();
                   return sendVerificationCode();
               }else if(foundJobSeeker.size()>0){
                   userType="jobseeker";
                   userId=foundJobSeeker.get(0).getId();
                   return sendVerificationCode();
               }else{
                   log.info("email not found");
                   return false;
               }


    }

    public Boolean sendVerificationCode() {
        log.info("email found");
        Random random = new Random();
        verificationCode = random.nextInt(90000000) + 10000000;
        String body="Verification code: "+verificationCode;
        String subject="Verification Code";

        return emailService.sendEmail(userEmail,body,subject);
    }

    public Boolean checkVerificationCode(Integer code) {
        if(code.equals(verificationCode)){
            return true;
        }else{
            return false;
        }
    }

    public Boolean updatePassword(String password) {
        if(userType.equals("employer")){
            return employerService.updatePassword(userId,userEmail,password);
        }else if(userType.equals("jobseeker")){
            return jobSeekerService.updatePassword(userId,userEmail,password);
        }else{
            return false;
        }

    }
}
