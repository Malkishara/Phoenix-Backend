package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.service.VacanciesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class AdminController {
    @Autowired
    private VacanciesService vacanciesService;

    @GetMapping("/vacancy")
    public @ResponseBody
    List<Vacancies> getAllVacancies() {
        log.info("All Vacancies..");
        log.info(String.valueOf(vacanciesService.getAllVacancies()));
        return vacanciesService.getAllVacancies();
    }
}
