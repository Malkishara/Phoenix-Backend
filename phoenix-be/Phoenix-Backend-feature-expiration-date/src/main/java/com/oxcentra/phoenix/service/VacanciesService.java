package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.model.Vacancy;

import java.util.List;
import java.util.Optional;

public interface VacanciesService {

    List<Vacancies> getAllVacancies();

    List<Vacancies> getAllVacanciesByCompanyId(Integer id);

    Boolean deleteVacancyById(Integer id);

    Optional<Vacancies> getVacancyById(Integer id);

    Boolean updateVacancy(Vacancy vacancy);

    Boolean addVacancy(Vacancy vacancy);

    void deleteVacancyByCompanyId(Integer id);

    List<Vacancies> getVacanciesBySearchText(String title);
}
