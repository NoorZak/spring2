package com.spring2.driverslicense.demo.services;


import com.spring2.driverslicense.demo.models.Person;
import com.spring2.driverslicense.demo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a book
    public Person createPerson(Person l) {
        return personRepository.save(l);
    }
    // retrieves a book

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> findUnlicensed() {
        return personRepository.findUnlicensed();
    }






}