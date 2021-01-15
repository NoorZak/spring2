package com.example.authentication.demo.repositories;

import com.example.authentication.demo.models.Event;
import com.example.authentication.demo.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository  extends CrudRepository<Message,Long> {
List<Message> findAllByEvent(Event event);

}
