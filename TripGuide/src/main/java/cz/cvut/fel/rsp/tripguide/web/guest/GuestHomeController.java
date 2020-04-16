package cz.cvut.fel.rsp.tripguide.web.guest;

import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest")
public class GuestHomeController {

    private final DestinationService destinationService;

    @Autowired
    public GuestHomeController(DestinationService destinationService) {
        this.destinationService = destinationService;
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

    @GetMapping("/contact")
    public String getGuestContactPage() {
        return "tourist/contact";
    }

}
