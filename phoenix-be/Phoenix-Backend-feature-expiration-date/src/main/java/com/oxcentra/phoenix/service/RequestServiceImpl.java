package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Request;
import com.oxcentra.phoenix.repository.JobseekerRequestRepository;
import com.oxcentra.phoenix.repository.RequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RequestServiceImpl implements RequestService{
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestCountService requestCountService;

    @Override
    public Boolean addRequest(Request request) {
        log.info(String.valueOf(request.getJobSeeker()));
        requestRepository.save(request);
        requestCountService.updateRequestCount(request.getVacancy());
        log.info("True");
        return true;
    }

    @Override
    public Boolean deleteRequestById(Integer id) {
        Optional<Request> request=getRequestById(id);
        requestCountService.deleteRequest(request.get().getVacancy());
       requestRepository.deleteById(id);
       log.info("deleted request");
       return true;
    }

    @Override
    public Optional<Request> getRequestById(Integer id) {
        return requestRepository.findById(id);
    }
}
