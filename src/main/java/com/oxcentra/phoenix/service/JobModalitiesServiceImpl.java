package com.oxcentra.phoenix.service;


import com.oxcentra.phoenix.model.JobModalities;
import com.oxcentra.phoenix.repository.JobModalitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobModalitiesServiceImpl implements JobModalitiesService {
    @Autowired
    private JobModalitiesRepository jobModalitiesRepository;

    public List<JobModalities> getAllJobModalities(){
        return jobModalitiesRepository.findAll();
    }
}
