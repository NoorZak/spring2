package com.example.dojooverflow.demo.controllers;

import com.example.dojooverflow.demo.models.Answer;
import com.example.dojooverflow.demo.models.NewQuestion;
import com.example.dojooverflow.demo.models.Question;
import com.example.dojooverflow.demo.models.TagQuestion;
import com.example.dojooverflow.demo.services.AnswerService;
import com.example.dojooverflow.demo.services.QuestionService;
import com.example.dojooverflow.demo.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class QuestionsController {
    private final QuestionService questionService;

    private final TagService tagService;


    private final AnswerService answerService;

    public QuestionsController(QuestionService questionService,TagService tagService,AnswerService answerService) {
        this.questionService=questionService;
        this.tagService=tagService;
        this.answerService=answerService;

    }


    @RequestMapping("")
    public String hi() {
        return "hi.jsp";
    }


    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("newquestion") NewQuestion newquestion) {
          return "newQuestion.jsp";
    }



    @RequestMapping(value="/questions", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newquestion") NewQuestion newquestion, BindingResult result) {
        if (result.hasErrors()) {
            return "newQuestion.jsp";
        } else
        {
            System.out.println(newquestion.getQuestion());
            System.out.println(newquestion.getTags());

            questionService.createQuestion(newquestion);
            return "redirect:/questions/new";
        }
    }

    @RequestMapping("/questions")
    public String show( Model model) {
        model.addAttribute("questions",questionService.allQuestions());
        /*System.out.println(questionService.allQuestions().get(0).getQuestion());
       */

        return "showQuestions.jsp";
    }

    @RequestMapping("/questions/{id}")
    public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {

        Question question = questionService.findQuestion(id);
        model.addAttribute("question", question);
        return "addAnswer.jsp";
    }


    @RequestMapping(value="/questions/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "addAnswer.jsp";
        } else {
            answerService.createAnswer(answer,questionService.findQuestion(id));
//            answerService.createAnswer(answer);



            return "redirect:/questions/{id}";
        }
    }


}

