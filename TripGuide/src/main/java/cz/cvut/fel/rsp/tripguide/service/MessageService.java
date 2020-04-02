package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    private final UserService userService;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public Message findMessage(Integer id) {
        Optional<Message> message = messageRepository.findById(id);
        if (!message.isPresent()) {
            throw new NotFoundException("Message not found! ID: " + id);
        }
        return message.get();
    }

    public Message save(Message message) {
        return this.messageRepository.save(message);
    }

    public void remove(Message message) {
        this.messageRepository.delete(message);
    }

    public void remove(Integer id) {
        this.messageRepository.deleteById(id);
    }

    public Message addMessage(Message message, User user) {
        message.setUser(user);
        message = messageRepository.save(message);
        return message;
    }

    public Message addMessage(Message message, Integer userId) {
        User user = userService.findUser(userId);
        message.setUser(user);
        message = save(message);
        return message;
    }

    public Message addMessage(Integer messageId, Integer userId) {
        Message message = findMessage(messageId);
        User user = userService.findUser(userId);
        message.setUser(user);
        message = save(message);
        return message;
    }

    public Message updateMessage(Message message, Integer messageId) {
        Message messageToUpdate = findMessage(messageId);
        if(message.getText() != null && !message.getText().isEmpty()) {
            messageToUpdate.setText(message.getText());
        }
        if(message.getUser() != null) {
            messageToUpdate.setUser(message.getUser());
        }
        messageToUpdate = save(messageToUpdate);
        return messageToUpdate;
    }

}
