package com.example.dojooverflow.demo.services;

import com.example.dojooverflow.demo.models.Tag;
import com.example.dojooverflow.demo.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository=tagRepository;
    }

    public List<Tag> allTags() {
        return tagRepository.findAll();
    }


    public Tag findTag(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }

    public Tag findTagBySubject(String subject){
        Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
        if( optionalTag.isPresent()  ) {
            return optionalTag.get();
        }
        else {
            return null;
        }

    }



    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public Tag createTag(Tag l) {
        return tagRepository.save(l);
    }


    public Tag updateTag(Long id, String subject) {
        Optional <Tag> update = tagRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setSubject(subject);
            tagRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}
