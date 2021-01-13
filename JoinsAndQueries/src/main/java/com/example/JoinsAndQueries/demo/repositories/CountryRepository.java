package com.example.JoinsAndQueries.demo.repositories;

import com.example.JoinsAndQueries.demo.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository  extends CrudRepository<Country,Long> {

    @Query(value = "select countries.name , languages.language ,languages.percentage from countries join languages on countries.id = languages.country_id  and languages.language ='Slovene'",nativeQuery = true)
            List<Object[]>  findCountrySlov();

    @Query(value = "select countries.name , count(cities.name) as total from countries , cities where cities.country_id = countries.id group by countries.name order by total desc",nativeQuery = true)
    List<Object[]> totalNumCities();



    @Query (value="    select  countries.name , languages.language,languages.percentage from countries join languages on languages.country_id = countries.id   where languages.percentage >89 group by countries.name order by languages.percentage desc",nativeQuery = true)
    List<Object[]> above98();

    @Query (value="select  * from countries  where countries.surface_area >501 and countries.population<10000",nativeQuery = true)
    List<Country> suface501Pop100000();

    @Query (value="    select * from countries where government_form = 'Constitutional Monarchy' and capital>200 and life_expectancy >75",nativeQuery = true)
    List<Country> Constitutional_Monarchy_Countries();


    @Query (value= "select countries.name  as countryname, cities.name as cityname , cities.district  ,cities.population from countries join cities on countries.id = cities.country_id where countries.name = 'Argentina' and cities.district ='Buenos Aires'  and countries.population >500000",nativeQuery = true)
    List<Object[]> BuenosAiresdistrict();


    @Query (value= "select  region, count(name) as numberofcountries from countries group by region order by count(name) desc",nativeQuery = true)
    List<Object[]> CountByReggion();





}
