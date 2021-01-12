package com.spring2.dojosninjas.demo.services;

import com.spring2.dojosninjas.demo.repositories.DojoRepository;
import com.spring2.dojosninjas.demo.models.Dojo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository=dojoRepository;
    }

    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }

    public Dojo createDojo(Dojo l) {
         return dojoRepository.save(l);
    }

    public List<Object[]> f(){

        return  dojoRepository.findAllDojosNamesWithId2();
    }


}