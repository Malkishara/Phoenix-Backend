package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.JobseekerRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class JobseekerRequestController {

    @Autowired
    private JobseekerRequestService jobseekerRequestService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/request/{id}")
    public @ResponseBody
    List<JobseekerRequest> getAllRequestByVacancyId(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return jobseekerRequestService.getAllRequestByVacancyId(id);
    }
}
