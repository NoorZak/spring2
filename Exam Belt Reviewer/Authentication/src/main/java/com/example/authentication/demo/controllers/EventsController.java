package com.example.authentication.demo.controllers;

import com.example.authentication.demo.models.Event;
import com.example.authentication.demo.models.Message;
import com.example.authentication.demo.models.State;
import com.example.authentication.demo.models.User;
import com.example.authentication.demo.services.EventService;
import com.example.authentication.demo.services.MessageService;
import com.example.authentication.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EventsController {

    private final EventService eventService;
    private final UserService userService;
    private  final MessageService messageService;


    public EventsController(EventService eventService, UserService userService, MessageService messageService) {
        this.eventService=eventService;
        this.userService=userService;

        this.messageService = messageService;
    }



    @RequestMapping("/edit/{id}")
    public String openEdit(Model model, HttpSession session , @PathVariable("id") Long event_id){

        if (session.getAttribute("user_id")==null)
            return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
        User user = userService.findUserById(id);
        Event event =eventService.getById(event_id);
        model.addAttribute("event",event);
        model.addAttribute("states",State.States);

        return "editEvent.jsp";

          }




    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT)
    public String editEvent(@Valid@ModelAttribute("event")Event event_from_form,Model model, HttpSession session , @PathVariable("id") Long event_id){

        if (session.getAttribute("user_id")==null)
            return "redirect:/login";


        eventService.updateEvent(event_from_form.getId(),event_from_form.getName(),event_from_form.getCity(),event_from_form.getState(),event_from_form.getEventDate());

        return "/edit/{id}";

    }






    @RequestMapping("/join/{id}")
    public String join(Model model, HttpSession session , @PathVariable("id") Long event_id){

        if (session.getAttribute("user_id")==null)
            return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
        User user = userService.findUserById(id);
        Event event =eventService.getById(event_id);

        eventService.join(event,user);
        return "redirect:/events";
    }


    @RequestMapping("/cancel/{id}")
    public String cancel(Model model, HttpSession session , @PathVariable("id")Long event_id){

        if (session.getAttribute("user_id")==null)
            return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
        User user = userService.findUserById(id);
        Event event =eventService.getById(event_id);

        eventService.cancel(event,user);
        return "redirect:/events";
    }


    @RequestMapping("/delete/{id}")
    public String delete(Model model, HttpSession session , @PathVariable("id") Long event_id){

        if (session.getAttribute("user_id")==null)
            return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
        User user = userService.findUserById(id);

        eventService.deleteEvent(event_id);
        return "redirect:/events";
    }


    @RequestMapping("/events/{id}")
    public String index(@ModelAttribute("message")Message message, @PathVariable("id") Long event_id, Model model, HttpSession session){
        if (session.getAttribute("user_id")==null)
            return "redirect:/login";

        Long id =(Long) session.getAttribute("user_id");
        User user = userService.findUserById(id);
        Event event = eventService.getById(event_id);
        model.addAttribute("att",eventService.getAtt(event));
        model.addAttribute("event", event);

        return "showEvent.jsp";
    }





    @RequestMapping("/events")
    public String index(@ModelAttribute("event") Event event, Model model,HttpSession session){
 if (session.getAttribute("user_id")==null)
         return "redirect:/login";

    Long id =(Long) session.getAttribute("user_id");
    User user = userService.findUserById(id);
model.addAttribute("user",user);
        model.addAttribute("events",eventService.findAllByState(user.getState()));
        model.addAttribute("eventsNot",eventService.findAllExcept(user.getState()));
        model.addAttribute("states", State.States);

        return "eventsPage.jsp";
    }


    @RequestMapping(value = "/events" ,method = RequestMethod.POST)
    public String addEvent(@Valid @ModelAttribute("event") Event event, Model model, HttpSession session)

    {
        User user = userService.findUserById((Long)session.getAttribute("user_id"));
        eventService.createEvent(event,user);
        return "redirect:/events";
    }



    @RequestMapping(value = "/message/{id}" ,method = RequestMethod.POST)
    public String addEvent(@Valid @ModelAttribute("message") Message message,@PathVariable("id") Long event_id ,Model model, HttpSession session)

    {
        User user = userService.findUserById((Long)session.getAttribute("user_id"));
        Event event =eventService.getById(event_id);
        messageService.createEvent(message,event,user);
        return "redirect:/events/{id}";
    }
}






