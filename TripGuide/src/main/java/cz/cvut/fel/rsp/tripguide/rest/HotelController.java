package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public Hotel save(Hotel hotel) {
        return hotelService.save(hotel);
    }

    public void remove(Hotel hotel) {
        hotelService.remove(hotel);
    }

    public void remove(Integer id) {
        hotelService.remove(id);
    }

    public Hotel find(Integer id) {
        return hotelService.findHotel(id);
    }

//    todo makha
}
