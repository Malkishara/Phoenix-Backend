package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmailController {

    @Autowired
    private EmployerService employerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/verify/employer")
    public @ResponseBody
    Boolean getJobEmployerByEmail(@RequestBody String value) {

        log.info(value);
        Integer code = Integer.parseInt(value);

        return employerService.verifyUser(code);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/resend/employer")
    public @ResponseBody
    Boolean resendVerificationCode() {

        return employerService.sendVerificationCode();
    }
}
