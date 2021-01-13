package com.example.JoinsAndQueries.demo.controllers;

import com.example.JoinsAndQueries.demo.models.City;
import com.example.JoinsAndQueries.demo.models.Country;
import com.example.JoinsAndQueries.demo.services.ApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
private final ApiService apiService;
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public List<Object[]> start(){
//
    return apiService.findCountrySlov();



}



    @RequestMapping("/total")
    public List<Object[]> start1(){
//
//
        return apiService.totalNumCities();


    }

    @RequestMapping("/above98")
    public List<Object[]> start2(){
//
//
        return apiService.above98();


    }

    @RequestMapping("/surf")
    public List<Country> start3(){
//
//
        return apiService.suface501Pop100000();


    }


    @RequestMapping("/cons")
    public List<Country> start4(){
//
//
        return apiService.Constitutional_Monarchy_Countries();


    }



    @RequestMapping("/b")
    public List<Object[]> start7(){
//
//
        return apiService.BuenosAiresdistrict();


    }




    @RequestMapping("/count")
    public List<Object[]> start6(){
//
//
        return apiService.CountByReggion();


    }


    @RequestMapping("/mex")
    public List<City> start5(){
//
//
        return apiService.citiesMexicoAbove500000();


    }


}

