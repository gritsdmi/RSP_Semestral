package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tourist/tours")
public class TouristTourController {

    private final TourService tourService;

    @Autowired
    public TouristTourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String tourPage(Model model) {
        model.addAttribute("tour", tourService.getAllTours());
        return "tourist/tours";
    }

    @GetMapping("/{id}/detail")
    public String tourInfoPage(Model model, @PathVariable Integer id) {
        model.addAttribute("tour", tourService.findTour(id));
        return "tourist/tour-detail";
    }

    @GetMapping("/{city}")
    public String tourPage(Model model, @PathVariable String city) {
        model.addAttribute("tours", tourService.findToursByCityName(city));
        return "tourist/tours";
    }

}
