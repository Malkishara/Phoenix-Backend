package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Request;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.JobseekerRequestService;
import com.oxcentra.phoenix.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class JobseekerRequestController {

    @Autowired
    private JobseekerRequestService jobseekerRequestService;

    @Autowired
    RequestService requestService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/request/{id}")
    public @ResponseBody
    List<JobseekerRequest> getAllRequestByVacancyId(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return jobseekerRequestService.getAllRequestByVacancyId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/request")
    public @ResponseBody Boolean addEmployer(@RequestBody Request request){



        return requestService.addRequest(request);
    }

    @DeleteMapping("/request/{id}")
    public @ResponseBody
    Boolean deleteRequestById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return requestService.deleteRequestById(id);
    }
}
