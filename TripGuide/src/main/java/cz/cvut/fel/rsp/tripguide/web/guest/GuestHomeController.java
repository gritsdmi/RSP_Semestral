package cz.cvut.fel.rsp.tripguide.web.guest;

import cz.cvut.fel.rsp.tripguide.dto.ContactUsDto;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/guest")
public class GuestHomeController {

    private final DestinationService destinationService;

    private final MailServiceImpl mailService;

    @ModelAttribute("contactUs")
    public ContactUsDto contactUsDto() {
        return new ContactUsDto();
    }

    @Autowired
    public GuestHomeController(DestinationService destinationService, MailServiceImpl mailService) {
        this.destinationService = destinationService;
        this.mailService = mailService;
    }

    @GetMapping("/home")
    public String getGuestHomePage() {
        return "tourist/index";
    }

    @GetMapping("/destinations")
    public String getGuestDestinationPage(Model model) {
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "tourist/destinations";
    }

    @GetMapping("/contact")
    public String getContactUs() {
        return "tourist/contact";
    }

    @PostMapping("/contact")
    public String contactUs(@ModelAttribute("contactUs") @Valid ContactUsDto contactUsDto, Model model) {
        mailService.sendEmail(contactUsDto);
        return "redirect:/guest/contact?success";
    }

}
