package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.dto.*;
import com.oxcentra.phoenix.model.*;
import com.oxcentra.phoenix.service.VacanciesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class VacanciesController {

    @Autowired
    private VacanciesService vacanciesService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vacancies")
    public @ResponseBody
    List<Vacancies> getAllVacancies() {

        return vacanciesService.getAllVacancies();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/search_data")
    public @ResponseBody
    List<Vacancies> getAllSearchData_(@RequestBody SearchData data) {
        log.info("{}", data);

        final String category = data.getCategory_id();
        final Type[] type = data.getType();
        final Modality[] modality = data.getModality();
        final SearchText[] search = data.getSearch_text();

        final List<String> modalityIdList =
                Arrays.asList(modality).stream().map(m -> m.getId()).collect(Collectors.toList());

        final List<String> typeIdList =
                Arrays.asList(type).stream().map(t -> t.getId()).collect(Collectors.toList());

        final List<String> searchTextList =
                Arrays.asList(search).stream().map(s -> s.getWord()).collect(Collectors.toList());

        final List<Vacancies> vacancies = vacanciesService.getAllVacancies();
        log.info("full count : {}", vacancies.size());

        List<Vacancies> searchVacancies = new ArrayList<>();
        List<Vacancies> matchedVacanciesForSearchedTextList=new ArrayList<>();

        if(searchTextList.stream().count()!=0){
            String[] jobPositionWord;

            for(int i=0;i<vacancies.size();i++){
                var num=0;
                jobPositionWord=vacancies.get(i).getTitle().split(" ");
                for(int j=0;j<searchTextList.size();j++){
                    for(int k=0;k<jobPositionWord.length;k++){
                        if(searchTextList.get(j).equals(jobPositionWord[k])){
                            num++;
                        }
                    }
                }
                if(num>0){
                    matchedVacanciesForSearchedTextList.add(vacancies.get(i));

                }
            }
            log.info("count "+matchedVacanciesForSearchedTextList.stream().count());
            log.info(String.valueOf(matchedVacanciesForSearchedTextList));
            if (category != null) {
                if(!category.equals("0")) {
                    if (typeIdList.stream().count() != 0) {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v -> category.equals(v.getCategory().getId()) && modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v -> category.equals(v.getCategory().getId()) && typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        }
                    } else {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v -> category.equals(v.getCategory().getId()) && modalityIdList.contains(v.getModality().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v -> category.equals(v.getCategory().getId()))
                                            .collect(Collectors.toList());
                        }
                    }
                }else{
                    if (typeIdList.stream().count() != 0) {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v -> modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v ->  typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        }
                    } else {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList.stream()
                                            .filter(
                                                    v ->  modalityIdList.contains(v.getModality().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies =
                                    matchedVacanciesForSearchedTextList;

                        }
                    }

                }
            } else {
                if (typeIdList.stream().count() != 0) {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                matchedVacanciesForSearchedTextList.stream()
                                        .filter(
                                                v -> modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies =
                                matchedVacanciesForSearchedTextList.stream()
                                        .filter(
                                                v -> typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    }
                } else {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                matchedVacanciesForSearchedTextList.stream()
                                        .filter(
                                                v -> modalityIdList.contains(v.getModality().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies =
                                matchedVacanciesForSearchedTextList;
                    }
                }
            }


        }else {
            if (category != null ) {
                if(!category.equals("0")){
                if (typeIdList.stream().count() != 0) {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> category.equals(v.getCategory().getId()) && modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> category.equals(v.getCategory().getId()) && typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    }
                } else {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> category.equals(v.getCategory().getId()) && modalityIdList.contains(v.getModality().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies = vacancies.stream()
                                .filter(
                                        v -> category.equals(v.getCategory().getId()))
                                .collect(Collectors.toList());
                    }
                }
                }else{
                    if (typeIdList.stream().count() != 0) {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    vacancies.stream()
                                            .filter(
                                                    v ->  modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies =
                                    vacancies.stream()
                                            .filter(
                                                    v ->  typeIdList.contains(v.getType().getId()))
                                            .collect(Collectors.toList());
                        }
                    } else {
                        if (modalityIdList.stream().count() != 0) {
                            searchVacancies =
                                    vacancies.stream()
                                            .filter(
                                                    v ->  modalityIdList.contains(v.getModality().getId()))
                                            .collect(Collectors.toList());
                        } else {
                            searchVacancies = vacancies;
                        }
                    }
                }
            } else {
                if (typeIdList.stream().count() != 0) {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> modalityIdList.contains(v.getModality().getId()) && typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> typeIdList.contains(v.getType().getId()))
                                        .collect(Collectors.toList());
                    }
                } else {
                    if (modalityIdList.stream().count() != 0) {
                        searchVacancies =
                                vacancies.stream()
                                        .filter(
                                                v -> modalityIdList.contains(v.getModality().getId()))
                                        .collect(Collectors.toList());
                    } else {
                        searchVacancies =
                                vacancies;
                    }
                }
            }

        }
        log.info("filtered count : {}", searchVacancies.size());
        log.info("{}", searchVacancies);
        return searchVacancies;
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/company")
    public @ResponseBody
    List<Vacancies> getVacanciesByCompany(@RequestBody SearchByCompany data) {
        log.info(String.valueOf(data.getId()));
        List<Vacancies> vacancies = vacanciesService.getAllVacancies();
        List<Vacancies> searchVacancies = new ArrayList<>();
        for (int i = 0; i < vacancies.stream().count(); i++) {
            if (data.getId()==vacancies.get(i).getEmployer().getId()) {
                searchVacancies.add(vacancies.get(i));
            }
        }


        log.info("{}",searchVacancies.size());
        log.info("{}",searchVacancies);
        return searchVacancies;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vacancies/{id}")
    public @ResponseBody
    List<Vacancies> getAllVacanciesByCompanyId(@PathVariable Integer id) {
       log.info(String.valueOf(id));
        return vacanciesService.getAllVacanciesByCompanyId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/vacancy/{id}")
    public @ResponseBody
    Boolean deleteVacancyById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return vacanciesService.deleteVacancyById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vacancy/{id}")
    public @ResponseBody
    Optional<Vacancies> getVacancyById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        log.info(String.valueOf(vacanciesService.getVacancyById(id)));
        return vacanciesService.getVacancyById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/vacancy/{id}")
    public @ResponseBody
    Boolean updateVacancy(@RequestBody Vacancy vacancy) {

        log.info(String.valueOf(vacancy.getId()));
        return vacanciesService.updateVacancy(vacancy);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/vacancy")
    public @ResponseBody
    Boolean addVacancy(@RequestBody Vacancy vacancy) {

        log.info(String.valueOf(vacancy));
        return vacanciesService.addVacancy(vacancy);
    }

}
