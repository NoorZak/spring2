package com.example.authentication.demo.controllers;

import com.example.authentication.demo.models.State;
import com.example.authentication.demo.models.User;
import com.example.authentication.demo.services.UserService;
import com.example.authentication.demo.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UsersController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user,Model model)

    {
        model.addAttribute("states", State.States);

        return "registrationPage.jsp";
    }


    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Model model) {
        userValidator.validate(user, result);

        if(result.hasErrors()) {
            model.addAttribute("states", State.States);
            return "registrationPage.jsp";
        }
          else {
          userService.registerUser(user);

          session.setAttribute("user_id", user.getId());
          return "redirect:/events";
      }// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@ModelAttribute("user")User user,@RequestParam("email1") String email, @RequestParam("password1") String password, Model model, HttpSession session) {
        if (userService.findByEmail(email)==null){
            model.addAttribute("error","Email incorrect");
            return "registrationPage.jsp";

        }
        else {
            boolean isAuthenticated = userService.authenticateUser(email, password);
            if (isAuthenticated) {
                session.setAttribute("user_id", userService.findByEmail(email).getId());
                return "redirect:/events";
            } else {

                model.addAttribute("error", "Password incorrect");
                return "registrationPage.jsp";

            }
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    if (session.getAttribute("user_id")!=null)
    session.invalidate();

  return "redirect:/registration";

      }
}
