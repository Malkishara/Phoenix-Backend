package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobTypes;
import com.oxcentra.phoenix.repository.JobTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypesServiceImpl implements JobTypesService {
    @Autowired
    private JobTypesRepository jobTypesRepository;

    public List<JobTypes> getAllJobTypes(){
        return jobTypesRepository.findAll();
    }
}
