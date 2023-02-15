package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobModalities;
import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.repository.JobModalitiesRepository;
import com.oxcentra.phoenix.repository.VacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacanciesServiceImpl implements VacanciesService{
    @Autowired
    private VacanciesRepository vacanciesRepository;

    public List<Vacancies> getAllVacancies(){
        return vacanciesRepository.findAll();
    }
}
