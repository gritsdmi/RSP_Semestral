package cz.cvut.fel.rsp.tripguide.web;

import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.UserRepository;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @ModelAttribute("user")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) {
        User email_existing = userRepository.findByUsername(userDto.getEmail());
        User username_existing = userRepository.findByUsername(userDto.getUsername());
        if (email_existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (username_existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (!userDto.getPassword().equals(userDto.getRepassword())) {
            result.rejectValue("password", null, "Passwords are not match.");
        }
        if (userDto.getUsername().length() > 20) {
            result.rejectValue("username", null, "MAX: 20");
        }

        if (userDto.getPassword().length() < 8) {
            result.rejectValue("password", null, "MIN: 8");
            result.rejectValue("repassword", null, "MIN: 8");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.regUser(userDto);

        return "redirect:/registration?success";
    }
}
