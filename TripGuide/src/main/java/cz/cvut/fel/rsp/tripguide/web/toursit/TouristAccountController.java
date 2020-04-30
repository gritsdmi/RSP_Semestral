package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tourist/account")
public class TouristAccountController {

    private final UserService userService;

    @Autowired
    public TouristAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String accountPage(Principal principal, Model model) {

        User user = userService.findUser(principal.getName());

        Set<Tour> allUserTours = user.getTours();

        Set<Tour> history = allUserTours
                .stream()
                .filter(t -> t.getDateTimeTil().isBefore(LocalDateTime.now()))
                .collect(Collectors.toSet());

        Set<Tour> current = allUserTours
                .stream()
                .filter(t -> t.getDateTimeTil().isAfter(LocalDateTime.now()))
                .collect(Collectors.toSet());

        model.addAttribute("user", user);
        model.addAttribute("current", current);
        model.addAttribute("history", history);
        model.addAttribute("all", user.getTours());

        return "tourist/accountpage";
    }
}
