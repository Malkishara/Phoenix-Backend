package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jobseeker_signup")
    public @ResponseBody
    String addJobSeeker( @RequestBody JobSeekerDto jobSeekerDto){


        String id=jobSeekerService.addJobSeeker(jobSeekerDto);
       log.info(id);
        return id;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jobseeker")
    public @ResponseBody
    JobSeeker getJobSeekerByEmail(@RequestBody JobSeekerDto jobSeekerDto) {

        log.info(String.valueOf(jobSeekerDto.getId()));
        return jobSeekerService.getJobSeekerById(jobSeekerDto.getId());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/jobseeker/{id}")
    public @ResponseBody
    Boolean updateJobSeekerData(@RequestBody JobSeeker jobSeeker) {

        log.info(String.valueOf(jobSeeker.getId()));
        log.info(jobSeeker.getEmail());
        log.info(String.valueOf(jobSeeker.getSkills()));
        return jobSeekerService.updateJobSeeker(jobSeeker);
    }


}
