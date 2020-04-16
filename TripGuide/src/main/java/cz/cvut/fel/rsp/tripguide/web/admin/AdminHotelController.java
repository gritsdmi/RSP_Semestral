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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public String addHotel(@ModelAttribute("hotel") @Valid HotelDto dto){
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setDestination(destinationService.findDestination(dto.getDestination()));
        hotel.setStars(Integer.parseInt(dto.getStars()));
        hotel.setAddress(dto.getAddress());
        hotel.setEmail(dto.getEmail());
        hotel.setPhoneNumber(dto.getPhoneNumbrer());
        hotel.setWeb(dto.getWeb());
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            hotel.setBreakfastTime_from(new Time(formatter.parse(dto.getBreakfastTime_from()).getTime()));
        } catch (ParseException ignored) {}
        try {
            hotel.setBreakfastTime_to(new Time(formatter.parse(dto.getBreakfastTime_to()).getTime()));
        } catch (ParseException ignored) { }
        try {
            hotel.setDinnerTime_from(new Time(formatter.parse(dto.getDinnerTime_from()).getTime()));
        } catch (ParseException ignored) {}
        try {
            hotel.setDinnerTime_to(new Time(formatter.parse(dto.getDinnerTime_to()).getTime()));
        } catch (ParseException ignored) {}
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
