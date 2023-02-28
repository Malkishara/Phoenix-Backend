package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jobseeker_signup")
    public @ResponseBody
    String addJobSeeker(@RequestBody JobSeekerDto jobSeekerDto){

        String id=jobSeekerService.addJobSeeker(jobSeekerDto);
        log.info(id);
        return id;
    }
}
