package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class EventServiceTest {

    @Autowired
    public EventService eventService;

    @Autowired
    public UserService userService;

    @Test
    public void createEventTest() {
        Event event = Generator.generateEvent();
        assertEquals(event, eventService.save(event));

        User user = Generator.generateUser();
        event = Generator.generateEvent();
        assertNotNull(eventService.addEvent(event, user));

        user = userService.save(Generator.generateUser());
        event = Generator.generateEvent();
        assertNotNull(eventService.addEvent(event, user.getId()));

        user = userService.save(Generator.generateUser());
        event = eventService.save(Generator.generateEvent());
        assertNotNull(eventService.addEvent(event.getId(), user.getId()));
    }

    @Test
    public void getEventTest() {
        Event event = Generator.generateEvent();
        eventService.save(event);

        assertEquals(event, eventService.findEvent(event.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeEventTest() {
        Event event = Generator.generateEvent();
        eventService.save(event);

        eventService.remove(event.getId());

        eventService.findEvent(event.getId());
    }
}
