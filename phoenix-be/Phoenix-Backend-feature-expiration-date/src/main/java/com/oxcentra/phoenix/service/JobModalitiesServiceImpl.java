package com.oxcentra.phoenix.service;


import com.oxcentra.phoenix.model.JobModalities;
import com.oxcentra.phoenix.repository.JobModalitiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobModalitiesServiceImpl implements JobModalitiesService {
    @Autowired
    private JobModalitiesRepository jobModalitiesRepository;

    public List<JobModalities> getAllJobModalities(){
        return jobModalitiesRepository.findAll();
    }

    @Override
    public Boolean addModality(JobModalities jobModalities) {
        log.info(jobModalities.getTitle());
        jobModalitiesRepository.save(jobModalities);
        return true;
    }

    @Override
    public Boolean updateModality(JobModalities jobModalities) {
        log.info(jobModalities.getTitle());
        jobModalitiesRepository.save(jobModalities);
        return true;
    }

    @Override
    public Boolean deleteModalityById(String id) {
        log.info(id);
        jobModalitiesRepository.deleteById(id);
        return true;
    }
}
