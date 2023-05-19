package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Request;

import java.util.Optional;

public interface RequestService {
    Boolean addRequest(Request request);

    Boolean deleteRequestById(Integer id);

    Optional<Request> getRequestById(Integer id);
}
