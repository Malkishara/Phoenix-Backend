package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.RequestCount;

import java.util.Optional;

public interface RequestCountService {



    Boolean updateRequestCount(Integer id);

    void deleteRequest(Integer vacancy);
}
