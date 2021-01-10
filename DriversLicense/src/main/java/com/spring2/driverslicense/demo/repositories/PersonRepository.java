package com.spring2.driverslicense.demo.repositories;

import com.spring2.driverslicense.demo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends CrudRepository<Person, Long> {
    List<Person> findAll();

    void deleteById(Long id);



}
