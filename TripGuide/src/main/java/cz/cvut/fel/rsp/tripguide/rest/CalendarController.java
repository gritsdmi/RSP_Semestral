package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.dto.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CalendarController {
    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping("/{userId}")
    public List<Event> getUserEvents(@PathVariable Integer userId) {
        List<Event> events = new ArrayList<>();
        //test data
        for(int i = 0; i <= 10; i++) {
            Event e = new Event();
            e.setDaysOfWeek(new int[]{1,2,3});
            e.setEnd("test data");
            e.setEndRecur("test data");
            e.setEndTime("test data");
            e.setStart("test data");
            e.setStartRecur("test data");
            e.setStartTime("test data");
            e.setTitle("test data");
            e.setUrl("test data");
            events.add(e);
        }
        return events;
    }

}
