package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.repository.JobseekerRequestRepository;
import com.oxcentra.phoenix.repository.RequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobseekerRequestServiceImpl implements JobseekerRequestService{

    @Autowired
    private JobseekerRequestRepository jobseekerRequestRepository;

    @Autowired
    private RequestCountService requestCountService;

    @Autowired
    private RequestRepository requestRepository;


    @Override
    public List<JobseekerRequest> getAllRequestByVacancyId(Integer id) {
        List<JobseekerRequest> jobseekerRequests = new ArrayList<>();


        jobseekerRequests=jobseekerRequestRepository.findAll().stream().filter(r->id.equals(r.getVacancy().getId())).collect(Collectors.toList());

        log.info(String.valueOf(jobseekerRequests));
        return jobseekerRequests;
    }

    @Override
    public Boolean addRequest(JobseekerRequest jobseekerRequest) {
        log.info(String.valueOf(jobseekerRequest.getJobSeeker()));
        jobseekerRequestRepository.save(jobseekerRequest);
        requestCountService.updateRequestCount(jobseekerRequest.getVacancy().getId());
        log.info("True");
        return true;
    }

    @Override
    public void removeRequest(Integer id) {

        log.info("Remove requests of jobseeker id "+id);
      requestRepository.deleteByJobSeekerId(id);
      requestCountService.decreaseCountByVacancyId(getRequestByJobSeekerId(id));
      log.info("Deleted");
    }

    @Override
    public List<JobseekerRequest> getRequestByJobSeekerId(Integer id) {
        List<JobseekerRequest> jobseekerRequests = new ArrayList<>();


        jobseekerRequests=jobseekerRequestRepository.findAll().stream().filter(r->id.equals(r.getJobSeeker().getId())).collect(Collectors.toList());

        log.info(String.valueOf(jobseekerRequests));
        return jobseekerRequests;
    }
}
