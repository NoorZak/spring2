package com.example.JoinsAndQueries.demo.repositories;

import com.example.JoinsAndQueries.demo.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long> {

}
