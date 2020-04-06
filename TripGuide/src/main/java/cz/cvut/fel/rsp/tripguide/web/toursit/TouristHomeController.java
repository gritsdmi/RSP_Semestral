package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.dto.DestinationDto;
import cz.cvut.fel.rsp.tripguide.dto.SearchDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tourist/home")
public class TouristHomeController {

    @GetMapping
    public String home() {
        return "tourist/index";
    }

}
