package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.HotelDto;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import cz.cvut.fel.rsp.tripguide.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/hotels")
public class AdminHotelController {
    private final HotelService hotelService;
    private final DestinationService destinationService;

    @Autowired
    public AdminHotelController(HotelService hotelService, DestinationService destinationService) {
        this.hotelService = hotelService;
        this.destinationService = destinationService;
    }

    @ModelAttribute("hotel")
    public HotelDto hotelDto() {
        return new HotelDto();
    }

    @PostMapping("/add")
    public String addDestination(@ModelAttribute("hotel") @Valid HotelDto dto){
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setDestination(destinationService.findDestination(dto.getDestination()));
        hotel.setStars(Integer.parseInt(dto.getStars()));
        hotel.setAddress(dto.getAddress());
        hotel.setEmail(dto.getEmail());
        hotel.setPhoneNumber(dto.getPhoneNumbrer());
        hotel.setWeb(dto.getWeb());
        hotelService.save(hotel);
        return "redirect:/admin/home";
    }

    @GetMapping
    public String getAllHotels(Model model){
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "admin/allhotels";
    }

    @GetMapping("/{id}")
    public String getHotel(Model model, @PathVariable Integer id){
        model.addAttribute("hotel", hotelService.findHotel(id));
        return "admin/hotel";
    }

    @GetMapping("/add")
    public String getAddHotelPage() {
        return "admin/createhotel";
    }
}
