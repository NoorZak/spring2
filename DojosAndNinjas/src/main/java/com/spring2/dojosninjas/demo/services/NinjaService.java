package com.spring2.dojosninjas.demo.services;

import com.spring2.dojosninjas.demo.models.Ninja;
import com.spring2.dojosninjas.demo.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository=ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public Ninja createNinja(Ninja l) {
        return ninjaRepository.save(l);
    }



}
