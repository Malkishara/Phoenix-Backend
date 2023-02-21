package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.common.VacancyUtil;
import com.oxcentra.phoenix.model.*;
import com.oxcentra.phoenix.service.VacanciesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class VacanciesController {

    @Autowired
    private VacanciesService vacanciesService;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/vacancies")
    public @ResponseBody List<Vacancies> getAllVacancies(){

       return vacanciesService.getAllVacancies();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/search_data")
    public @ResponseBody List<Vacancies> getAllSearchData(@RequestBody SearchData data){
        log.info(data.getCategory_id());

        Type[] type=data.getType();
        Modality[] modality=data.getModality();
        SearchText[] search=data.getSearch_text();


        List<Vacancies> vacancies=vacanciesService.getAllVacancies();
        List<Vacancies> searchVacancies = new ArrayList<>();

        log.info(vacancies.get(1).getTitle());

        for(int p=0;p<vacancies.stream().count();p++){
            if(type.length!=0){
                for(int i=0;i<type.length;i++){
                    if(modality.length!=0){
                        for(int j=0;j< modality.length;j++){
                            if(search.length!=0) {

                                String position=vacancies.get(p).getTitle();
                                String wordsPosition[]=position.split(" ");
                                int num=0;

                                for(int q=0;q<wordsPosition.length;q++){
                                    for(int k=0;k< search.length;k++){
                                        log.info(wordsPosition[q]+" "+search[k].getWord());
                                       if(wordsPosition[q].equals(search[k].getWord())){
                                           num++;

                                       }
                                    }
                                }
                                log.info(String.valueOf(num));
                                if(num>0) {
                                    if (data.getCategory_id() != null) {
                                        if (type[i].getId().equals(vacancies.get(p).getType().getId()) && modality[j].getId().equals(vacancies.get(p).getModality().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("1 " + p);
                                        }
                                    } else {
                                        if (type[i].getId().equals(vacancies.get(p).getType().getId()) && modality[j].getId().equals(vacancies.get(p).getModality().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("2 " + p);
                                        }
                                    }

                                }

                            }  else{

                                if (data.getCategory_id() != null) {
                                    if (type[i].getId().equals(vacancies.get(p).getType().getId()) && modality[j].getId().equals(vacancies.get(p).getModality().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                        searchVacancies.add(vacancies.get(p));
                                        log.info("1 " + p);
                                    }
                                } else {
                                    if (type[i].getId().equals(vacancies.get(p).getType().getId()) && modality[j].getId().equals(vacancies.get(p).getModality().getId())) {
                                        searchVacancies.add(vacancies.get(p));
                                        log.info("2 " + p);
                                    }
                                }

                            }
                        }
                    }else{
                        if(search.length!=0) {
                            String position=vacancies.get(p).getTitle();
                            String wordsPosition[]=position.split(" ");
                            int num=0;

                            for(int q=0;q<wordsPosition.length;q++){
                                for(int k=0;k< search.length;k++){
                                    if(wordsPosition[q].equals(search[k].getWord())){
                                        num++;
                                    }
                                }
                            }
                            if(num>0) {

                                    if (data.getCategory_id() != null) {
                                        if (type[i].getId().equals(vacancies.get(p).getType().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("3 " + p);
                                        }
                                    } else {
                                        if (type[i].getId().equals(vacancies.get(p).getType().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("4 " + p);
                                        }
                                    }

                            }
                        }  else{

                            if (data.getCategory_id() != null) {
                                if (type[i].getId().equals(vacancies.get(p).getType().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                    searchVacancies.add(vacancies.get(p));
                                    log.info("3 " + p);
                                }
                            } else {
                                if (type[i].getId().equals(vacancies.get(p).getType().getId())) {
                                    searchVacancies.add(vacancies.get(p));
                                    log.info("4 " + p);
                                }
                            }

                        }
                    }
                }
            }else{
                if(modality.length!=0){
                    for(int j=0;j< modality.length;j++){
                        if(search.length!=0) {
                            String position=vacancies.get(p).getTitle();
                            String wordsPosition[]=position.split(" ");
                            int num=0;

                            for(int q=0;q<wordsPosition.length;q++){
                                for(int k=0;k< search.length;k++){
                                    log.info(wordsPosition[q]+" "+search[k].getWord());
                                    if(wordsPosition[q].equals(search[k].getWord())){
                                        num++;

                                    }
                                }
                            }
                            if(num>0) {

                                    if (data.getCategory_id() != null) {
                                        if (modality[j].getId().equals(vacancies.get(p).getModality().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("5 " + p);
                                        }
                                    } else {
                                        if (modality[j].getId().equals(vacancies.get(p).getModality().getId())) {
                                            searchVacancies.add(vacancies.get(p));
                                            log.info("6 " + p);
                                        }
                                    }

                            }
                        }else{
                            if (data.getCategory_id() != null) {
                                if (modality[j].getId().equals(vacancies.get(p).getModality().getId()) && data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                    searchVacancies.add(vacancies.get(p));
                                    log.info("5 " + p);
                                }
                            } else {
                                if (modality[j].getId().equals(vacancies.get(p).getModality().getId())) {
                                    searchVacancies.add(vacancies.get(p));
                                    log.info("6 " + p);
                                }
                            }

                        }
                    }
                }else{
                    if(search.length!=0) {
                        String position=vacancies.get(p).getTitle();
                        String wordsPosition[]=position.split(" ");
                        int num=0;

                        for(int q=0;q<wordsPosition.length;q++){
                            for(int k=0;k< search.length;k++){
                                log.info(wordsPosition[q]+" "+search[k].getWord());
                                if(wordsPosition[q].equals(search[k].getWord())){
                                    num++;

                                }
                            }
                        }
                        if(num>0) {
                            if (data.getCategory_id() != null) {
                                if (data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                    searchVacancies.add(vacancies.get(p));
                                    log.info("7 " + p);
                                }
                            }else{

                                searchVacancies.add(vacancies.get(p));
                            }
                        }

                    }else{
                        if (data.getCategory_id() != null) {
                            if (data.getCategory_id().equals(vacancies.get(p).getCategory().getId())) {
                                searchVacancies.add(vacancies.get(p));
                                log.info("7 " + p);
                            }
                        }else{
                            searchVacancies.add(vacancies.get(p));
                        }
                    }
                }
            }
        }

           log.info(String.valueOf(searchVacancies));

        return searchVacancies;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/company")
    public @ResponseBody List<Vacancies> getVacanciesByCompany(@RequestBody SearchByCompany data){
        List<Vacancies> vacancies=vacanciesService.getAllVacancies();
        List<Vacancies> searchVacancies = new ArrayList<>();
       for(int i=0;i<vacancies.stream().count();i++){
           if(data.getId().equals(vacancies.get(i).getCompany().getId())){
               searchVacancies.add(vacancies.get(i));
           }
       }
        return searchVacancies;
    }
}
