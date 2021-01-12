package com.example.dojooverflow.demo.services;

import com.example.dojooverflow.demo.models.Answer;
import com.example.dojooverflow.demo.models.NewQuestion;
import com.example.dojooverflow.demo.models.Question;
import com.example.dojooverflow.demo.models.Tag;
import com.example.dojooverflow.demo.repositories.QuestionRepository;
import com.example.dojooverflow.demo.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final TagService tagService;
    private final  AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository,TagRepository tagRepository,TagService tagService,AnswerService answerService) {
        this.questionRepository=questionRepository;
        this.tagRepository=tagRepository;
        this.tagService=tagService;
        this.answerService=answerService;
    }

    public List<Question> allQuestions() {
        return questionRepository.findAll();
    }


    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public Question createQuestion(NewQuestion q) {

        Question question = new Question();
        question.setQuestion(q.getQuestion());

         for (String s : q.splitTags()){
           if(tagService.findTagBySubject(s) !=null)
           {

           }

           else{

               Tag tag = new Tag();
               tag.setSubject(s);
               tagService.createTag(tag);

           }

             question.getTags().add(tagService.findTagBySubject(s));

        }

        questionRepository.save(question);

        return question;

    }


    public Question updateQuestion(Long id, Answer answer) {
        Optional <Question> update = questionRepository.findById(id);
        if(update != null && update.isPresent()) {

            update.get().getAnswers().add(answer);
            questionRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}
