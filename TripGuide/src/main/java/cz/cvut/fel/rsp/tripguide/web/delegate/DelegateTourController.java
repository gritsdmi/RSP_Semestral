package cz.cvut.fel.rsp.tripguide.web.delegate;

import cz.cvut.fel.rsp.tripguide.dto.EventDto;
import cz.cvut.fel.rsp.tripguide.dto.MessageDto;
import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.EventType;
import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.EventService;
import cz.cvut.fel.rsp.tripguide.service.MessageService;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
@RequestMapping("/delegate/tour")
public class DelegateTourController {

    private final TourService tourService;
    private final UserService userService;
    private final MessageService messageService;
    private final EventService eventService;

    @Autowired
    public DelegateTourController(TourService tourService, UserService userService, MessageService messageService, EventService eventService) {
        this.tourService = tourService;
        this.userService = userService;
        this.messageService = messageService;
        this.eventService = eventService;
    }

    @ModelAttribute("newmessage")
    public MessageDto messageDto(){ return new MessageDto(); }
    @ModelAttribute("newevent")
    public EventDto eventDto(){ return new EventDto(); }

    @GetMapping("/{id}")
    public String getTour(Model model, @PathVariable Integer id){
        model.addAttribute("tour", tourService.findTour(id));
        model.addAttribute("tourists", userService.getTouristsByTour(tourService.findTour(id)));
        model.addAttribute("messages", messageService.findMessagesByTour(id));
        model.addAttribute("events", eventService.findEventsByTour(tourService.findTour(id)));
        model.addAttribute("types", EventType.values());
        return "delegate/tour";
    }

    @PostMapping("/{id}/message")
    public String addMessage(@PathVariable Integer id, @ModelAttribute("newmessage") @Valid MessageDto messageDto){
        Message message = new Message();
        message.setText(messageDto.getText());
        messageService.addMessage(message, id);
        return "redirect:/delegate/tour/"+id+"?mess";
    }

    @PostMapping("/{id}/event")
    public String addEvent(@PathVariable Integer id, @ModelAttribute("newevent") @Valid EventDto eventDto){

        DateFormat formatter = new SimpleDateFormat("HH:mm");

        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setType(eventDto.getEventType());
        if(eventDto.getRegular().equals("yes")) {
            event.setStartRecur(LocalDate.parse(eventDto.getStartRecur()));
            event.setEndRecur(LocalDate.parse(eventDto.getEndRecur()));
            event.setDaysOfWeek(eventDto.getDaysOfWeek());
            try {
                event.setStartTime(new Time(formatter.parse(eventDto.getStartTime()).getTime()));
            } catch (ParseException ignored) { }
            try {
                event.setEndTime(new Time(formatter.parse(eventDto.getEndTime()).getTime()));
            } catch (ParseException ignored) { }
        }else{
            event.setStart(LocalDateTime.parse(eventDto.getStart()));
            event.setEnd(LocalDateTime.parse(eventDto.getEnd()));
        }
        event.setRegular(eventDto.getRegular().equals("yes"));
        event.setTour(tourService.findTour(id));
        eventService.save(event);
        return "redirect:/delegate/tour/"+id+"?events";
    }
    @PostMapping("/{tourid}/event/{eventid}/addtourist")
    public String addTouristToEvent(@PathVariable Integer eventid, @PathVariable Integer tourid, @RequestParam String username){
        User user = userService.findUser(username);
        Event event = eventService.findEvent(eventid);
        user = userService.addEvent(user, event);
        return "redirect:/delegate/tour/"+tourid+"?events";
    }
}