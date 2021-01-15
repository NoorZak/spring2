package com.example.authentication.demo.services;

import com.example.authentication.demo.models.Event;
import com.example.authentication.demo.models.User;
import com.example.authentication.demo.repositories.EventRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
private EventRepository eventRepository;




    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }



    public  Event getById(Long id){
        return eventRepository.getById(id);
    }
   public List<Event>findAll(){
        return eventRepository.findAll();
    }


    public List<Event>findAllByState(String state){
        return eventRepository.findAllByState(state);
    }


    public List<Event>findAllExcept(String state){
        return eventRepository.findAllExcept(state);
    }


    public Event createEvent(Event event,User user) {
        event.setPlanner(user);
        return eventRepository.save(event);

    }

    public Event updateEvent(Long id, String name, String city, String state, Date date) {
        Optional<Event> update = eventRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setName(name);
            update.get().setCity(city);
            update.get().setState(state);
            eventRepository.save(update.get());
            return update.get();
        }
        return null;
    }

    public Event join(Event event,User user) {
        event.getAttendees().add(user);
        return eventRepository.save(event);

    }


    public List<User> getAtt(Event event) {
       return event.getAttendees();
    }

    public Event cancel(Event event,User user) {
        event.getAttendees().remove(user);
        return eventRepository.save(event);

    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }





}
