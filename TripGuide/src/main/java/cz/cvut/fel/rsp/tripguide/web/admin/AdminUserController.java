package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.HotelDto;
import cz.cvut.fel.rsp.tripguide.dto.NewUserDto;
import cz.cvut.fel.rsp.tripguide.model.Role;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Set;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @ModelAttribute("user")
    public NewUserDto userDto() {
        return new NewUserDto();
    }

    @Autowired
    public AdminUserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String  getAllUsers(Model model){
        model.addAttribute("tourists", userService.getAllUsers());
        return "admin/allusers";
    }

    @PostMapping("/add")
    public String  createUser(@ModelAttribute("user") @Valid NewUserDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        switch (dto.getRole()) {
            case "Tourist":
                user.setRoles(Collections.singleton(Role.TOURIST));
                break;
            case "Delegate":
                user.setRoles(Collections.singleton(Role.DELEGATE));
                break;
            case "Admin":
                user.setRoles(Collections.singleton(Role.ADMIN));
                break;
        }
        user.setUsername(dto.getUsername());
        user.setPhoneNumber(dto.getPhoneNumber());
        userService.save(user);
        return "redirect:/admin/users";
    }



}
