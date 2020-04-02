package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.DestinationDto;
import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/dest")
public class AdminDestinationController {

    private final DestinationService destinationService;

    @Autowired
    public AdminDestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @ModelAttribute("destination")
    public DestinationDto destinationDto() {
        return new DestinationDto();
    }

    @PostMapping("/add")
    public String addDestination(@ModelAttribute("destination") @Valid DestinationDto dto){
        Destination destination = new Destination();
        destination.setName(dto.getName());
        destination.setCountry(dto.getCountry());
        destinationService.save(destination);
        return "redirect:/admin/home";
    }

    @GetMapping
    public String getAllDestinations(Model model){
        model.addAttribute("destinations", destinationService.getAllDestinations());
        return "admin/alldest";
    }

    @GetMapping("/{id}")
    public String getDestination(Model model, @PathVariable Integer id){
        model.addAttribute("dest", destinationService.findDestination(id));
        return "admin/dest";
    }

    @GetMapping("/add")
    public String getAddDestinationPage() {
        return "admin/createdest";
    }

}
