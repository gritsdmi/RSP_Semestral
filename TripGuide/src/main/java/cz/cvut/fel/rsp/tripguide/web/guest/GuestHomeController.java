package cz.cvut.fel.rsp.tripguide.web.guest;

import cz.cvut.fel.rsp.tripguide.dto.ContactUsDto;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.MailServiceImpl;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Controller
@RequestMapping("/guest")
public class GuestHomeController {

    private final DestinationService destinationService;

    private final TourService tourService;

    private final MailServiceImpl mailService;

    @ModelAttribute("contactUs")
    public ContactUsDto contactUsDto() {
        return new ContactUsDto();
    }

    @Autowired
    public GuestHomeController(DestinationService destinationService, TourService tourService, MailServiceImpl mailService) {
        this.destinationService = destinationService;
        this.tourService = tourService;
        this.mailService = mailService;
    }

    @GetMapping("/home")
    public String getGuestHomePage() {
        return "tourist/index";
    }

    @GetMapping("/destinations")
    public String getGuestDestinationPage(Model model) {
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "tourist/destinations";
    }

    @GetMapping("/destinations/{destId}/tours")
    public String getDestinationTours(Model model, @PathVariable Integer destId) {

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        model.addAttribute("tours", destinationService.findAllDestinationTours(destId)
                .stream()
                .map(tour -> {
                    String date = tour.getDateTimeFrom().format(formatterDate) + " - " + tour.getDateTimeTil().format(formatterDate);
                    return new Pair(date,tour);
                })
                .collect(Collectors.toSet())
        );
        return "tourist/tours";
    }

    @GetMapping("/destinations/{destId}/tours/{tourId}")
    public String getTourInfo(Model model, @PathVariable Integer destId, @PathVariable Integer tourId) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Tour tour = tourService.findTour(tourId);
        model.addAttribute("date", tour.getDateTimeFrom().format(formatterDate) + " - " + tour.getDateTimeTil().format(formatterDate));
        model.addAttribute("tour", tour);
        model.addAttribute("attractions", destinationService.findDestination(destId).getLocalAttractions());
        // TODO add avaliable dates, but first we need to implement them in admin menu.
        return "tourist/tour-detail";
    }

    @GetMapping("/contact")
    public String getContactUs() {
        return "tourist/contact";
    }

    @PostMapping("/contact")
    public String contactUs(@ModelAttribute("contactUs") @Valid ContactUsDto contactUsDto, Model model) {
        mailService.sendEmail(contactUsDto);
        return "redirect:/guest/contact?success";
    }

}
