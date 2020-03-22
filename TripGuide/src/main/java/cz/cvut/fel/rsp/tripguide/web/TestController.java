package cz.cvut.fel.rsp.tripguide.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("registration")
    public String test() {
        return "registration";
    }
}
