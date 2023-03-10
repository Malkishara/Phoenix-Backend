package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JwtRequest;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthenticationService extends UserDetailsService {

   String userType(JwtRequest jwtRequest);

   @Override
   UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
