package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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
        model.addAttribute("user", user);
        return "tourist/accountpage";
    }
}
