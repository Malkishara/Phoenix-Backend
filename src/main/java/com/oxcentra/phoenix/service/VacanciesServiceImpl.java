package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.Vacancies;
import com.oxcentra.phoenix.model.Vacancy;
import com.oxcentra.phoenix.repository.VacanciesRepository;
import com.oxcentra.phoenix.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VacanciesServiceImpl implements VacanciesService{
    @Autowired
    private VacanciesRepository vacanciesRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancies> getAllVacancies(){
        return vacanciesRepository.findAll();
    }

    @Override
    public List<Vacancies> getAllVacanciesByCompanyId(Integer id) {

        List<Vacancies> vacancies = new ArrayList<>();


        vacancies=getAllVacancies().stream().filter(v->id.equals(v.getCompany().getId())).collect(Collectors.toList());

        log.info(String.valueOf(vacancies));
        return vacancies;
    }

    @Override
    public Boolean deleteVacancyById(Integer id) {

        vacanciesRepository.deleteById(id);
        log.info("deleted");
        return true;
    }

    @Override
    public Optional<Vacancies> getVacancyById(Integer id) {
        return vacanciesRepository.findById(id);
    }

    @Override
    public Boolean updateVacancy(Vacancy vacancy) {
        log.info(vacancy.getTitle());
        vacancyRepository.save(vacancy);
        return true;
    }
}
