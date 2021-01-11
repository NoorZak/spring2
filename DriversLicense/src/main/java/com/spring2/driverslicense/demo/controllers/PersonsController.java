package com.spring2.driverslicense.demo.controllers;

import com.spring2.driverslicense.demo.models.Person;
import com.spring2.driverslicense.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class PersonsController {
    private final PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService=personService;
    }



    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "newUser.jsp";
    }


    @RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id,Model model) {
        Person person = personService.findPerson(id);
        model.addAttribute("person", person);
        return "show.jsp";
    }


    @RequestMapping(value="/persons", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "newUser.jsp";
        } else
            {
            personService.createPerson(person);
            return "redirect:/";
        }
    }




}