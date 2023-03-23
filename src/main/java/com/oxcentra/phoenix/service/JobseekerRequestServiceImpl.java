package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.repository.JobseekerRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobseekerRequestServiceImpl implements JobseekerRequestService{

    @Autowired
    private JobseekerRequestRepository jobseekerRequestRepository;


    @Override
    public List<JobseekerRequest> getAllRequestByVacancyId(Integer id) {
        List<JobseekerRequest> jobseekerRequests = new ArrayList<>();


        jobseekerRequests=jobseekerRequestRepository.findAll().stream().filter(r->id.equals(r.getVacancy().getId())).collect(Collectors.toList());

        log.info(String.valueOf(jobseekerRequests));
        return jobseekerRequests;
    }
}
