package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JwtRequest;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService,UserDetailsService{
    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobSeekerService jobSeekerService;

    List<Employer> foundEmployer=new ArrayList<>();
    List<JobSeeker> foundJobSeeker=new ArrayList<>();



   @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        foundEmployer=employerService.getAllEmployer().stream().filter(e->
                email.contains(e.getEmail())).collect(Collectors.toList());
        foundJobSeeker=jobSeekerService.getAllJobSeeker().stream().filter(s->
                email.contains(s.getEmail())).collect(Collectors.toList());


      if(foundEmployer.size()>0){
          return new User(foundEmployer.get(0).getEmail(),foundEmployer.get(0).getPassword(),new ArrayList<>());
      }else if(foundJobSeeker.size()>0){
          return new User(foundJobSeeker.get(0).getEmail(),foundJobSeeker.get(0).getPassword(),new ArrayList<>());
      }else{
          throw new UsernameNotFoundException("User not found");
      }


   }
}
