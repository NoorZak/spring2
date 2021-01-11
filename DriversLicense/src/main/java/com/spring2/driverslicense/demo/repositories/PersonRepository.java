package com.spring2.driverslicense.demo.repositories;

import com.spring2.driverslicense.demo.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PersonRepository  extends CrudRepository<Person, Long> {
    List<Person> findAll();

    void deleteById(Long id);

  @Query(value = "SELECT * FROM person WHERE person.id not IN ( SELECT license.person_id FROM license)",nativeQuery = true)
//   @Query(value = "SELECT person.* FROM person LEFT JOIN license ON person.id=license.person_id WHERE license.person_id IS NULL",nativeQuery = true)
    List<Person> findUnlicensed();



}
