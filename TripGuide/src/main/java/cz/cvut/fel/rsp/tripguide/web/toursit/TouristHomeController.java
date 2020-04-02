package cz.cvut.fel.rsp.tripguide.web.toursit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tourist/home")
public class TouristHomeController {

    @GetMapping
    public String home() {
        return "tourist/index";
    }

}
