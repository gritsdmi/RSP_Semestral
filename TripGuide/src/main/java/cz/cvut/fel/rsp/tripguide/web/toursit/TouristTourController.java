package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.Destination;

@Controller
@RequestMapping(value = "/tourist/destinations/{destId}/tours")
public class TouristTourController {

    private final TourService tourService;

    private final DestinationService destinationService;

    @Autowired
    public TouristTourController(TourService tourService, DestinationService destinationService) {
        this.tourService = tourService;
        this.destinationService = destinationService;
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
        // TODO add avaliabledates, but first we need to implement them in admin menu.
        return "tourist/tour-detail";
    }

}
