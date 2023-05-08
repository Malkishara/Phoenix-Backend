package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.EmployerDto;
import com.oxcentra.phoenix.model.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getAllEmployer();

    String addEmployer(EmployerDto employer);

    Employer getEmployerById(int id);

    Boolean updateEmployer(Employer employer);

    Boolean saveEmployer();

    Boolean updateEmployerVerification(Employer employer);

    Boolean verifyUser(Integer code);

    Boolean sendVerificationCode();

    Boolean updatePassword(Integer id,String userEmail, String password);

    List<Employer> getAllEmployers();

    Boolean deleteEmployerById(Integer id);

    List<Employer> getEmployersBySearchText(String title);
}
