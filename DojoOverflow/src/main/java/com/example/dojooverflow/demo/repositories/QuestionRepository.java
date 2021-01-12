package com.example.dojooverflow.demo.repositories;

import com.example.dojooverflow.demo.models.Question;
import com.example.dojooverflow.demo.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
    List<Question> findAll();

}
