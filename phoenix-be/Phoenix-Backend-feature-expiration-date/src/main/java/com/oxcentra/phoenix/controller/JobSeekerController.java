package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.JobSeekerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/jobseeker_signup")
    public @ResponseBody
    String addJobSeeker( @RequestBody JobSeekerDto jobSeeker){

         log.info(jobSeeker.getEmail());
        String id=jobSeekerService.addJobSeeker(jobSeeker);
       log.info(id);
        return id;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/jobseeker/{id}")
    public @ResponseBody
    JobSeeker getJobseekerById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        log.info(String.valueOf(jobSeekerService.getJobseekerById(id)));
        return jobSeekerService.getJobseekerById(id);
    }

    @GetMapping("/jobseeker")
    public @ResponseBody
    List<JobSeeker> getAllJobSeeker(){
        return jobSeekerService.getAllJobSeekers();
    }

    @DeleteMapping("/jobseeker/{id}")
    public @ResponseBody
    Boolean deleteJobSeekerById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return jobSeekerService.deleteJobSeekerById(id);
    }

    @PostMapping("/jobseeker/title")
    public @ResponseBody
    List<JobSeeker> getJobSeekersBySearchText(@RequestBody String title) {
        log.info(title);
        return jobSeekerService.getJobSeekersBySearchText(title);
    }

}