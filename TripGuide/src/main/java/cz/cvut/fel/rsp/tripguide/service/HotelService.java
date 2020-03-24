package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    private final TourService tourService;

    @Autowired
    public HotelService(HotelRepository hotelRepository, TourService tourService) {
        this.hotelRepository = hotelRepository;
        this.tourService = tourService;
    }

    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void remove(Integer id) {
        hotelRepository.deleteById(id);
    }

    public void remove(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    public Hotel findHotel(Integer id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(!hotel.isPresent()) {
            throw new NotFoundException("Hotel not found! ID: " + id);
        }
        return hotel.get();
    }

    public Hotel addHotel(Hotel hotel, Tour tour) {
        hotel.setTour(tour);
        hotel = save(hotel);
        return hotel;
    }

    public Hotel addHotel(Hotel hotel, Integer tourId) {
        return addHotel(hotel, tourService.findTour(tourId));
    }

    public Hotel addHotel(Integer hotelId, Integer tourId) {
        return addHotel(findHotel(hotelId), tourService.findTour(tourId));
    }

    public Hotel updateHotel(Hotel hotel, Integer hotelId) {
        Hotel hotelToUpdate = findHotel(hotelId);
        if(hotel.getAddress() != null) {
            hotelToUpdate.setAddress(hotel.getAddress());
        }
        if(hotel.getBreakfastTime() != null) {
            hotelToUpdate.setBreakfastTime(hotel.getBreakfastTime());
        }
        if(hotel.getDestination() != null) {
            hotelToUpdate.setDestination(hotel.getDestination());
        }
        if(hotel.getDinnerTime() != null) {
            hotelToUpdate.setDinnerTime(hotel.getDinnerTime());
        }
        if(hotel.getEmail() != null) {
            hotelToUpdate.setEmail(hotel.getEmail());
        }
        if(hotel.getName() != null) {
            hotelToUpdate.setName(hotel.getName());
        }
        if(hotel.getPhoneNumber() != null) {
            hotelToUpdate.setPhoneNumber(hotel.getPhoneNumber());
        }
        if(hotel.getStars() != null) {
            hotelToUpdate.setStars(hotel.getStars());
        }
        if(hotel.getTour() != null) {
            hotelToUpdate.setTour(hotel.getTour());
        }
        if(hotel.getWeb() != null) {
            hotelToUpdate.setWeb(hotel.getWeb());
        }
        if(hotel.getDestination() != null) {
            hotelToUpdate.setDestination(hotel.getDestination());
        }
        hotelToUpdate = save(hotelToUpdate);
        return hotelToUpdate;
    }
}
