package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.RequestCount;
import com.oxcentra.phoenix.repository.RequestCountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RequestCountServiceImpl implements RequestCountService{
    @Autowired
    private RequestCountRepository requestCountRepository;




    @Override
    public Boolean updateRequestCount(Integer id) {

        Optional<RequestCount> requestCount=requestCountRepository.findById(id);

        int numOfRequests=requestCount.get().getNumOfRequests();
        numOfRequests=numOfRequests+1;


        RequestCount existingRequestCount=requestCount.get();
        existingRequestCount.setNumOfRequests(numOfRequests);
        requestCountRepository.save(existingRequestCount);

        return true;
    }

    @Override
    public void deleteRequest(Integer vacancy) {
        Optional<RequestCount> requestCount=requestCountRepository.findById(vacancy);

        int numOfRequests=requestCount.get().getNumOfRequests();
        numOfRequests=numOfRequests-1;


        RequestCount existingRequestCount=requestCount.get();
        existingRequestCount.setNumOfRequests(numOfRequests);
        requestCountRepository.save(existingRequestCount);
    }

    @Override
    public void decreaseCountByVacancyId(List<JobseekerRequest> requestByJobSeekerId) {
        for(int i=1;i<=requestByJobSeekerId.size();i++){
          deleteRequest(requestByJobSeekerId.get(i).getVacancy().getId());
        }
    }
}
