package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.dto.SearchDto;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/tourist/destinations")
public class TouristDestinationController {

    private final DestinationService destinationService;

    @ModelAttribute("search")
    public SearchDto searchDto() {
        return new SearchDto();
    }

    @Autowired
    public TouristDestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public String destinationPage(Model model) {
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "tourist/destinations";
    }

    @PostMapping
    public String findDeestinations(@ModelAttribute("search") @Valid SearchDto searchDto, Model model) {
        model.addAttribute("destinations", destinationService.search(searchDto));
        return "tourist/destinations";
    }
}
