package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.EmployerService;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/verify/employer")
    public @ResponseBody
    Boolean verifyEmployerEmail(@RequestBody String value) {

        log.info(value);
        Integer code = Integer.parseInt(value);

        return employerService.verifyUser(code);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/resend/employer")
    public @ResponseBody
    Boolean resendEmployerVerificationCode() {

        return employerService.sendVerificationCode();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/verify/jobseeker")
    public @ResponseBody
    Boolean verifyJobSeekerEmail(@RequestBody String value) {

        log.info(value);
        Integer code = Integer.parseInt(value);

        return jobSeekerService.verifyUser(code);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/resend/jobseeker")
    public @ResponseBody
    Boolean resendJobSeekerVerificationCode() {
        return jobSeekerService.sendVerificationCode();
    }

    }
