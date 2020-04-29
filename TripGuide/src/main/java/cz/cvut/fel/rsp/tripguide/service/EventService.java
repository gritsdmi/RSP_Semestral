package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.EventRepository;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@SuppressWarnings("ALL")
@Service
public class EventService {

    private final EventRepository eventRepository;

    private final UserService userService;

    @Autowired
    public EventService(EventRepository eventRepository, UserService userService) {
        this.eventRepository = eventRepository;
        this.userService = userService;
    }

    public Event findEvent(Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        if (!event.isPresent()) {
            throw new NotFoundException("Message not found! ID: " + id);
        }
        return event.get();
    }

    public Set<Event> findEventsByTour(Tour tour) {
        return eventRepository.findAllByTourOrderByIdDesc(tour);
    }

    public Event save(Event event) {
        return this.eventRepository.save(event);
    }

    public void remove(Event event) {
        this.eventRepository.delete(event);
    }

    public void remove(Integer id) {
        this.eventRepository.deleteById(id);
    }

    public Event addEvent(Event event, User user) {
        event.addUser(user);
        event = save(event);
        return event;
    }

    public Event addEvent(Event event, Integer userId) {
        User user = userService.findUser(userId);
        event.addUser(user);
        event = save(event);
        return event;
    }

    public Event addEvent(Integer eventId, Integer userId) {
        Event event = findEvent(eventId);
        User user = userService.findUser(userId);
        event.addUser(user);
        event = save(event);
        return event;
    }

    public Event updateEvent(Event event, Integer eventId) {
        Event eventToUpdate = findEvent(eventId);
        if(event.getType() != null) {
            eventToUpdate.setType(event.getType());
        }
        if(event.getUsers() != null && !event.getUsers().isEmpty()) {
            eventToUpdate.setUsers(event.getUsers());
        }
        eventToUpdate = save(eventToUpdate);
        return eventToUpdate;
    }

}