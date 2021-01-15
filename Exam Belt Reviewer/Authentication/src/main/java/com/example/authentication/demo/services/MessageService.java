package com.example.authentication.demo.services;

import com.example.authentication.demo.models.Event;
import com.example.authentication.demo.models.Message;
import com.example.authentication.demo.models.User;
import com.example.authentication.demo.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {
private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public List<Message> findAllByEvent(Event event){
        return messageRepository.findAllByEvent(event);

    }
    public Message createEvent(Message message,Event event, User user) {
        message.setAuthor(user);
        message.setEvent(event);
        return messageRepository.save(message);

    }


}
