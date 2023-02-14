package com.oxcentra.phoenix.controller;


import com.oxcentra.phoenix.model.JobModalities;
import com.oxcentra.phoenix.service.JobModalitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobModalitiesController {
    @Autowired
    private JobModalitiesService jobModalitiesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/modalities")
    public List<JobModalities> getAllJobModalities(){
        return jobModalitiesService.getAllJobModalities();
    }
}
