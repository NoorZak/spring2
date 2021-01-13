package com.example.authentication.demo.controllers;

import com.example.authentication.demo.models.User;
import com.example.authentication.demo.services.UserService;
import org.mindrot.jbcrypt.BCrypt;
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

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {

        return "loginPage.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
      if(result.hasErrors())
          return "registrationPage.jsp";
      else {
          userService.registerUser(user);
          session.setAttribute("user_id", user.getId());
          return "redirect:/home";
      }// if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated =userService.authenticateUser(email,password);
        if (isAuthenticated)
        {
            session.setAttribute("user_id", userService.findByEmail(email).getId());
            return "redirect:/home";
        }
            else
        {
            model.addAttribute("error","User not Found");
            return "loginPage.jsp";

        }


    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
       if (session.getAttribute("user_id")==null)
           return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
       User user = userService.findUserById(id);
       model.addAttribute("user",user);
       return "homePage.jsp";

        }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    if (session.getAttribute("user_id")!=null)
    session.invalidate();

  return "redirect:/login";

      }
}
