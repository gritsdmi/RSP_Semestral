package cz.cvut.fel.rsp.tripguide.web.delegate;

import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delegate/home")
public class DelegateHomeController {

    private final TourService tourService;

    @Autowired
    public DelegateHomeController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String home(Model model, Authentication authentication) {

        User delegate = (User)authentication.getPrincipal();
        model.addAttribute("tours", tourService.findToursByDelegate(delegate.getId()));
        return "delegate/index";
    }
}