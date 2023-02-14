package com.oxcentra.phoenix.controller;


import com.oxcentra.phoenix.model.JobTypes;
import com.oxcentra.phoenix.service.JobTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobTypesController {

    @Autowired
    private JobTypesService jobTypesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/types")
    public List<JobTypes> getAllJobTypes(){
        return jobTypesService.getAllJobTypes();
    }

}
