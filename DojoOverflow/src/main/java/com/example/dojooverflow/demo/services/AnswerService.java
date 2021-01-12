package com.example.dojooverflow.demo.services;

import com.example.dojooverflow.demo.models.Answer;
import com.example.dojooverflow.demo.models.Question;
import com.example.dojooverflow.demo.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository=answerRepository;
    }

    public List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

/*
    public List<Answer> findUnCategorized(long category_id){
        return  answerRepository.findUnCategorized(category_id);

    }
*/
    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if(optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public Answer createAnswer(Answer a,Question q)

    {
        a.setQuestion(q);
        return answerRepository.save(a);
    }


    Answer getTopByCreatedAtAfter(){
        return answerRepository.findFirst1ByOrderByCreatedAtDesc();
    }

    public Answer updateAnswer(Long id, String text) {
        Optional <Answer> update = answerRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setText(text);
            answerRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}
