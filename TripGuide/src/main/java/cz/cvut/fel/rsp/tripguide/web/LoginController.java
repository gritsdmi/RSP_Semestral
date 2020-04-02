package cz.cvut.fel.rsp.tripguide.web;

import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @ModelAttribute("user")
    public UserDto userLoginDto() {
        return new UserDto();
    }

    @GetMapping
    public String login() {
        return "registration";
    }
}
