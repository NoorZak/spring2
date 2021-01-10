package com.spring2.dojosninjas.demo.controllers;


import com.spring2.dojosninjas.demo.models.Dojo;
import com.spring2.dojosninjas.demo.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DojosController {
    private final DojoService dojoService;

    public DojosController(DojoService dojoService) {
        this.dojoService=dojoService;
    }


    @RequestMapping("/dojos")
    public String newDojo(Model model) {
    model.addAttribute("dojos",dojoService.allDojos());
    return "dojos.jsp";
      }


    @RequestMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp";
    }

    @RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "show.jsp";
    }


    @RequestMapping(value="/dojos", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        } else
        {
            dojoService.createDojo(dojo);
            return "redirect:/";
        }
    }




}
