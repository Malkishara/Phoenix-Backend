package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobTypes;
import com.oxcentra.phoenix.repository.JobTypesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobTypesServiceImpl implements JobTypesService {
    @Autowired
    private JobTypesRepository jobTypesRepository;

    public List<JobTypes> getAllJobTypes(){
        return jobTypesRepository.findAll();
    }

    @Override
    public Boolean deleteTypeById(String id) {
       log.info(id);
       jobTypesRepository.deleteById(id);
       return true;
    }

    @Override
    public Boolean updateType(JobTypes jobTypes) {
        log.info(jobTypes.getTitle());
        jobTypesRepository.save(jobTypes);
        return true;
    }

    @Override
    public Boolean addType(JobTypes jobTypes) {
        log.info(jobTypes.getTitle());
        jobTypesRepository.save(jobTypes);
        return true;
    }
}
