package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.DestinationDto;
import cz.cvut.fel.rsp.tripguide.dto.LocalAttrDto;
import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.LocalAttraction;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.LocalAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/dest")
public class AdminDestinationController {

    private final DestinationService destinationService;
    private final LocalAttractionService laService;

    @Autowired
    public AdminDestinationController(DestinationService destinationService, LocalAttractionService laService) {
        this.destinationService = destinationService;
        this.laService = laService;
    }

    @ModelAttribute("destination")
    public DestinationDto destinationDto() {
        return new DestinationDto();
    }

    @ModelAttribute("attraction")
    public LocalAttrDto attrDto() {
        return new LocalAttrDto();
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

    @GetMapping("/{id}/allattr")
    public String getAllAttractionsByDestination(@PathVariable Integer id, Model model){
        model.addAttribute("attractions", laService.getLocalAttractionsByDestination(destinationService.findDestination(id)));
        model.addAttribute("dest", destinationService.findDestination(id));
        return "admin/allattrsbydest";
    }

    @GetMapping("/{id}/addattr")
    public String getAddAttractionPage(){
        return "admin/dest";
    }

    @PostMapping("/{id}/addattr")
    public String addAttraction(@PathVariable Integer id, @ModelAttribute("attraction") @Valid LocalAttrDto dto){
        LocalAttraction attraction = new LocalAttraction();
        attraction.setName(dto.getName());
        attraction.setDescription(dto.getDescription());
        attraction.setAddress(dto.getAddress());
        if(dto.getFree().equals("yes")) attraction.setFree(true);
        else attraction.setFree(false);
        laService.addLocalAttraction(attraction, id);
        return "redirect:/admin/dest/" + id + "/allattr";
    }

    @GetMapping("/{id}/hotels")
    public String destinationHotels(@PathVariable Integer id, Model model) {
        model.addAttribute("hotels", destinationService.findDestination(id).getHotels());
        return "admin/desthotels";
    }
}
