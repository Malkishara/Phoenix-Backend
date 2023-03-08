package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getAllEmployer();

    String addEmployer(EmployerDto employer);
}
