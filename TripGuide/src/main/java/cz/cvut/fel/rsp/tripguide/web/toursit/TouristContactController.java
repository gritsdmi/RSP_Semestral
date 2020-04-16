package cz.cvut.fel.rsp.tripguide.web.toursit;

import cz.cvut.fel.rsp.tripguide.dto.ContactUsDto;
import cz.cvut.fel.rsp.tripguide.dto.SearchDto;
import cz.cvut.fel.rsp.tripguide.service.MailService;
import cz.cvut.fel.rsp.tripguide.service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/tourist/contact")
public class TouristContactController {

    private final MailServiceImpl mailService;

    @Autowired
    public TouristContactController(MailServiceImpl mailService) {
        this.mailService = mailService;
    }

    @ModelAttribute("contactUs")
    public ContactUsDto contactUsDto() {
        return new ContactUsDto();
    }

    @GetMapping
    public String contactPage() {
        return "tourist/contact";
    }

    @PostMapping
    public String contactUs(@ModelAttribute("contactUs") @Valid ContactUsDto contactUsDto, Model model) {
        mailService.sendEmail(contactUsDto);
        return "redirect:/tourist/contact?success";
    }
}
