package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacanciesController {

    @Autowired
    private VacanciesService vacanciesService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vacancies")
    public List<Vacancies> getAllVacancies(){
        return vacanciesService.getAllVacancies();
    }
}
