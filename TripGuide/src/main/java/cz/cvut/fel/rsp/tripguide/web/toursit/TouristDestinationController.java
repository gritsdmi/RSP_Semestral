package cz.cvut.fel.rsp.tripguide.web.toursit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tourist/destination")
public class TouristDestinationController {
    @GetMapping
    public String destinationPage() {
        return "tourist/destinations";
    }
}
