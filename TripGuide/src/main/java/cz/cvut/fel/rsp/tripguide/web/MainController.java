package cz.cvut.fel.rsp.tripguide.web;

import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.UserRepository;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class MainController {

    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping(value = {"/", "", "/home"})
    public String userHomeController(Principal principal) {
        if (principal != null) {
            User user = userRepository.findByUsername(principal.getName());
            if(user != null) {
                if(user.isAdmin()) {
                    return "redirect:/admin/home";
                }
                if(user.isTourist()) {
                    return "redirect:/tourist/home";
                }
                if(user.isDelegate()) {
                    return "redirect:/delegate/home";
                }
            }
        }
        return "redirect:/guest/home";
    }

}
