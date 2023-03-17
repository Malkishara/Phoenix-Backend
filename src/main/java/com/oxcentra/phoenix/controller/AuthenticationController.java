package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.common.JwtUtility;
import com.oxcentra.phoenix.dto.JwtResponse;
import com.oxcentra.phoenix.dto.JwtRequest;
import com.oxcentra.phoenix.service.AuthenticationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private  AuthenticationService authenticationService;


    @Autowired
    private  AuthenticationManager authenticationManager;

    public AuthenticationController(JwtUtility jwtUtility,AuthenticationService authenticationService,AuthenticationManager authenticationManager){
       this.jwtUtility = jwtUtility;
        this.authenticationService=authenticationService;
        this.authenticationManager=authenticationManager;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    @ResponseBody
    public JwtResponse authentication(@RequestBody JwtRequest jwtRequest) throws Exception {

        log.info(jwtRequest.getEmail());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        }catch (BadCredentialsException e){
            log.info("Error");
            throw new Exception("Invalid credential",e);

        }


        final Boolean result=true;
        final String message="SUCCESS";
        final String token=jwtUtility.generateToken(jwtRequest.getEmail());
        final Date expiresAt=jwtUtility.extractExpiration(token);
        final int expiresIn=jwtUtility.jwtExpirationInMs;

        log.info(token);

        JwtResponse jwtResponse=new JwtResponse();


            jwtResponse.setUser_type(authenticationService.userType(jwtRequest));
            jwtResponse.setUser_id(authenticationService.userId(jwtRequest));
            jwtResponse.setResult(true);
            jwtResponse.setMessage("Success");
            jwtResponse.setAccess_token(jwtUtility.generateToken(jwtRequest.getEmail()));
            jwtResponse.setExpires_at(jwtUtility.extractExpiration(token));
            jwtResponse.setExpires_in(jwtUtility.jwtExpirationInMs);

        return jwtResponse;
    }



}
