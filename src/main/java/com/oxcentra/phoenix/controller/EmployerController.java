package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.service.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employer")
    public @ResponseBody
    Employer getEmployerByEmail(@RequestBody Employer employer) {

       log.info(String.valueOf(employer.getId()));

        return employerService.getEmployerById(employer.getId());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employer/{id}")
    public @ResponseBody
    Boolean updateEmployerData(@RequestBody Employer employer) {

        log.info(String.valueOf(employer.getId()));
        log.info(employer.getEmail());
        return employerService.updateEmployer(employer);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/verification/{id}")
    public @ResponseBody
    Boolean updateEmployerVerification(@RequestBody Employer employer) {

        log.info(String.valueOf(employer.getId()));
        return employerService.updateEmployerVerification(employer);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/companies")
    public @ResponseBody
    List<Employer> getAllEmployer(){
        return employerService.getAllEmployers();
    }


}
