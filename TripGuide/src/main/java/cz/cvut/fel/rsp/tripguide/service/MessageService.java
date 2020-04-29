package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    private final TourService tourService;

    @Autowired
    public MessageService(MessageRepository messageRepository, TourService tourService) {
        this.messageRepository = messageRepository;
        this.tourService = tourService;
    }

    public Message findMessage(Integer id) {
        Optional<Message> message = messageRepository.findById(id);
        if (!message.isPresent()) {
            throw new NotFoundException("Message not found! ID: " + id);
        }
        return message.get();
    }

    public Set<Message> findMessagesByTour(Integer tourId){
        return messageRepository.findAllByTourOrderByIdDesc(tourService.findTour(tourId));
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

    public Message addMessage(Message message, Tour tour) {
        message.setTour(tour);
        message = messageRepository.save(message);
        return message;
    }

    public Message addMessage(Message message, Integer tourId) {
        Tour tour = tourService.findTour(tourId);
        message.setTour(tour);
        message = save(message);
        return message;
    }

    public Message addMessage(Integer messageId, Integer userId) {
        Message message = findMessage(messageId);
        Tour tour = tourService.findTour(userId);
        message.setTour(tour);
        message = save(message);
        return message;
    }

    public Message updateMessage(Message message, Integer messageId) {
        Message messageToUpdate = findMessage(messageId);
        if(message.getText() != null && !message.getText().isEmpty()) {
            messageToUpdate.setText(message.getText());
        }
        if(message.getTour() != null) {
            messageToUpdate.setTour(message.getTour());
        }
        messageToUpdate = save(messageToUpdate);
        return messageToUpdate;
    }

}
