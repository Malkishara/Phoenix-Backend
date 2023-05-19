package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.common.PasswordUtility;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.EmailService;
import com.oxcentra.phoenix.service.EmployerService;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobSeekerService jobSeekerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordUtility passwordUtility;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/forgot")
    public @ResponseBody
    Boolean forgotPassword(@RequestBody String email) {

        log.info(email);

        return passwordUtility.sendEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/resend")
    public @ResponseBody
    Boolean resendVerificationCode() {
        return passwordUtility.sendVerificationCode();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/verify")
    public @ResponseBody
    Boolean checkVerificationCode(@RequestBody String value) {

        log.info(value);
        Integer code = Integer.parseInt(value);

        return passwordUtility.checkVerificationCode(code);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/update")
    public @ResponseBody
    Boolean updatePassword(@RequestBody String password) {

        log.info(password);

        return passwordUtility.updatePassword(password);
    }

    }
