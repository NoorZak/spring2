package com.example.authentication.demo.repositories;

import com.example.authentication.demo.models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
List<Event>findAll();
List<Event>findAllByState(String state);
@Query(value = "select  * from event where state != :state ",nativeQuery = true)
List<Event>findAllExcept(String state);

Event getById(Long id);






}
