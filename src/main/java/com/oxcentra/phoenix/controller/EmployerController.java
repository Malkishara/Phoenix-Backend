package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.service.CompaniesService;
import com.oxcentra.phoenix.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    public @ResponseBody String addEmployer(@RequestBody EmployerDto employer){

        String id=employerService.addEmployer(employer);
        log.info(id);
    return id;
    }
}
