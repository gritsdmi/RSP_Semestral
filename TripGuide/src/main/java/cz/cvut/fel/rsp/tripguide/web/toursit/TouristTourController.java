package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping(value = "/tourist/destinations/{destId}/tours")
public class TouristTourController {

    private final TourService tourService;

    private final DestinationService destinationService;

    private final UserService userService;

    @Autowired
    public TouristTourController(TourService tourService, DestinationService destinationService, UserService userService) {
        this.tourService = tourService;
        this.destinationService = destinationService;
        this.userService = userService;
    }

    @GetMapping
    public String tourPage(Model model, @PathVariable Integer destId) {
        model.addAttribute("tours", destinationService.findAllDestinationTours(destId));
        return "tourist/tours";
    }

    @GetMapping("/{tourId}")
    public String tourInfoPage(Model model,@PathVariable Integer destId, @PathVariable Integer tourId) {
        model.addAttribute("tour", tourService.findTour(tourId));
        model.addAttribute("attractions", destinationService.findDestination(destId).getLocalAttractions());
        // TODO add avaliable dates, but first we need to implement them in admin menu.
        return "tourist/tour-detail";
    }


    @PutMapping("/{tourId}")
    public String addTour(@PathVariable Integer destId, @PathVariable Integer tourId, Principal principal, HttpServletRequest request) {
        User user = userService.findUser(principal.getName());
        if(user.getTours().stream().map(Tour::getId).anyMatch(id -> id.equals(tourId))) {
            return "redirect:" + request.getRequestURI() + "?error";
        }
        userService.addTour(user, tourId);
        return "redirect:" + request.getRequestURI() + "?success";
    }

}
