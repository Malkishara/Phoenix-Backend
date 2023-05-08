package com.oxcentra.phoenix.controller;


import com.oxcentra.phoenix.model.JobCategory;
import com.oxcentra.phoenix.model.JobModalities;
import com.oxcentra.phoenix.service.JobModalitiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class JobModalitiesController {
    @Autowired
    private JobModalitiesService jobModalitiesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/modalities")
    public @ResponseBody List<JobModalities> getAllJobModalities(){
        return jobModalitiesService.getAllJobModalities();
    }

    @DeleteMapping("/modality/{id}")
    public @ResponseBody
    Boolean deleteModalityById(@PathVariable String id) {
        log.info(id);
        return jobModalitiesService.deleteModalityById(id);
    }

    @PutMapping("/modality/{id}")
    public @ResponseBody
    Boolean updateModalityData(@RequestBody JobModalities jobModalities) {

        log.info(jobModalities.getTitle());
        return jobModalitiesService.updateModality(jobModalities);
    }

    @PostMapping("/modality")
    public @ResponseBody
    Boolean addModality(@RequestBody JobModalities jobModalities) {

        log.info(jobModalities.getTitle());
        return jobModalitiesService.addModality(jobModalities);
    }
}
