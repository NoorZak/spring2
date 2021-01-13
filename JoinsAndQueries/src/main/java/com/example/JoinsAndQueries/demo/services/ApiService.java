package com.example.JoinsAndQueries.demo.services;

import com.example.JoinsAndQueries.demo.models.City;
import com.example.JoinsAndQueries.demo.models.Country;
import com.example.JoinsAndQueries.demo.repositories.CityRepository;
import com.example.JoinsAndQueries.demo.repositories.CountryRepository;
import com.example.JoinsAndQueries.demo.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    private  final CityRepository cityRepository;
    private  final CountryRepository countryRepository;
    private  final LanguageRepository languageRepository;

    public ApiService(CityRepository cityRepository, CountryRepository countryRepository, LanguageRepository languageRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.languageRepository = languageRepository;
    }


    public List<Object[]> findCountrySlov(){
        return     countryRepository.findCountrySlov();

    }

    public List<Object[]> totalNumCities(){
        return     countryRepository.totalNumCities();

    }



    public  List<Object[]> above98(){
        return  countryRepository.above98();
    }

    public List<Country> suface501Pop100000()
    {return countryRepository.suface501Pop100000();}


public     List<Country> Constitutional_Monarchy_Countries(){
        return  countryRepository.Constitutional_Monarchy_Countries();
}



      public List<Object[]> BuenosAiresdistrict(){
        return  countryRepository.BuenosAiresdistrict();

      }


   public List<Object[]> CountByReggion(){

        return  countryRepository.CountByReggion();

    }


 public    List<City> citiesMexicoAbove500000(){
        return  cityRepository.citiesMexicoAbove500000();
 }



}
