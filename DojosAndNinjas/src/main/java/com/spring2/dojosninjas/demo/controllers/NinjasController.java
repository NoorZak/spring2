package com.spring2.dojosninjas.demo.controllers;

import com.spring2.dojosninjas.demo.models.Ninja;
import com.spring2.dojosninjas.demo.services.DojoService;
import com.spring2.dojosninjas.demo.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjasController {
    private final NinjaService ninjaService;

    private final DojoService dojoService;

    public NinjasController(NinjaService ninjaService,DojoService dojoService) {
        this.ninjaService=ninjaService;
        this.dojoService=dojoService;

    }

    @RequestMapping(value="/")
    public String get() {
/*
        List<Object[]> dojos = dojoService.f();
        Object[] dojo = dojos.get(1);
        Object dojoId = dojo[0];
        Object dojoName = dojo[1];

        System.out.println(dojo);
        System.out.println(dojo[0]);
        System.out.println(dojo[1]);
*/
        return "hi.jsp";
    }



    @RequestMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos",dojoService.allDojos());
        return "newNinja.jsp";
    }



    @RequestMapping(value="/ninjas", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        } else
        {
            ninjaService.createNinja(ninja);
            return "redirect:/";
        }
    }




}