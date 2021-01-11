package com.spring2.driverslicense.demo.repositories;

import com.spring2.driverslicense.demo.models.License;
import com.spring2.driverslicense.demo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();

    void deleteById(Long id);

    License findTopByOrderByNumberDesc();
}
