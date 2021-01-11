package com.spring2.driverslicense.demo.controllers;

import com.spring2.driverslicense.demo.models.License;
import com.spring2.driverslicense.demo.models.Person;
import com.spring2.driverslicense.demo.services.LicenseService;
import com.spring2.driverslicense.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class LicensesController {
    private final LicenseService licenseService;

    private final PersonService personService;

    public LicensesController(LicenseService licenseService,PersonService personService) {
        this.licenseService = licenseService;
        this.personService=personService;

    }

    @RequestMapping(value="/")
    public String get() {
        return "hi.jsp";
    }



    @RequestMapping("/licenses/new")
    public String newLicense(@ModelAttribute("license") License license,Model model) {
       model.addAttribute("persons",personService.findUnlicensed());
        System.out.println(personService.findUnlicensed());
       return "newLicense.jsp";
    }



    @RequestMapping(value="/licenses", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "newLicense.jsp";
        } else
        {
            licenseService.createLicense(license);
            return "redirect:/";
        }
    }




}