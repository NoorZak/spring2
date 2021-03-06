package com.spring2.dojosninjas.demo.repositories;

import com.spring2.dojosninjas.demo.models.Dojo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    @Query(value="SELECT id, name FROM dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();


}



