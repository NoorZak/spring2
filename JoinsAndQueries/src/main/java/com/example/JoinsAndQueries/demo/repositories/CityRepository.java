package com.example.JoinsAndQueries.demo.repositories;

import com.example.JoinsAndQueries.demo.models.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City,Long> {

    @Query(value="select cities.name ,cities.population from countries , cities where cities.country_id = countries.id and countries.name ='Mexico' and cities.population > 500000 order by cities.population",nativeQuery = true)
    List<City> citiesMexicoAbove500000();

}
