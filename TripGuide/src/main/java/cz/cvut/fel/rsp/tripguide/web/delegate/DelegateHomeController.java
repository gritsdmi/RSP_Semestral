package cz.cvut.fel.rsp.tripguide.web.delegate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delegate/home")
public class DelegateHomeController {
    @GetMapping
    public String home() {
        return "delegate/index";
    }
}
