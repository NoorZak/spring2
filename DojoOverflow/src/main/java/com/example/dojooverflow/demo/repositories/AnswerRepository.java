package com.example.dojooverflow.demo.repositories;

import com.example.dojooverflow.demo.models.Answer;
import com.example.dojooverflow.demo.models.Question;
import com.example.dojooverflow.demo.services.AnswerService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
    List<Answer> findAll();
    Answer findFirst1ByOrderByCreatedAtDesc();

}
