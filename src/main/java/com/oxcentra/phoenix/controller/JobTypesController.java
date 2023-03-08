package com.oxcentra.phoenix.controller;


import com.oxcentra.phoenix.model.JobTypes;
import com.oxcentra.phoenix.service.JobTypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class JobTypesController {

    @Autowired
    private JobTypesService jobTypesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/types")
    public @ResponseBody List<JobTypes> getAllJobTypes(){

        log.info(String.valueOf(jobTypesService.getAllJobTypes()));
        return jobTypesService.getAllJobTypes();
    }

}
