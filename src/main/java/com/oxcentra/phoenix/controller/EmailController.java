package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
