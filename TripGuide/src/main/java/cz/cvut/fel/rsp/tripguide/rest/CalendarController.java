package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.dto.EventDto;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/events")
public class CalendarController {
    private final UserService userService;

    @Autowired
    public CalendarController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Set<EventDto> getUserEvents(@PathVariable Integer id) {
        return userService.generateUserEvents(id);
    }
}
