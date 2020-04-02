package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(path = "find/{id}", produces = "application/json")
    public Event find(@PathVariable("id") Integer id) {
        return eventService.findEvent(id);
    }

    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public Event save(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Event add(@RequestBody Event event, @RequestBody User user) {
        return eventService.addEvent(event, user);
    }

    @PostMapping(path = "/add/{id}", consumes = "application/json", produces = "application/json")
    public Event add(@RequestBody Event event, @PathVariable("id") Integer id) {
        return eventService.addEvent(event, id);
    }


    /* ============ */
    /* PUT REQUESTS */
    /* ============ */

    @PutMapping(path = "/add/{eventId}/{userId}", produces = "application/json")
    public Event add(@PathVariable("eventId") Integer eventId, @PathVariable("userId") Integer userId) {
        return eventService.addEvent(eventId, userId);
    }

    @PutMapping(path = "/update/{eventId}", consumes = "application/json", produces = "application/json")
    public Event update(@RequestBody Event event, @PathVariable("eventId") Integer eventId) {
        return eventService.updateEvent(event, eventId);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        eventService.remove(id);
    }

    @DeleteMapping(path = "/remove", consumes = "application/json")
    public void remove(Event event) {
        eventService.remove(event);
    }
}
