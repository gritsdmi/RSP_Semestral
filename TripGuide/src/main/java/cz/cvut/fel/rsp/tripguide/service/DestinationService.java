package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    private final HotelService hotelService;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository, HotelService hotelService) {
        this.destinationRepository = destinationRepository;
        this.hotelService = hotelService;
    }

    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }

    public void remove(Integer id) {
        destinationRepository.deleteById(id);
    }

    public void remove(Destination destination) {
        destinationRepository.delete(destination);
    }

    public Destination findDestination(Integer id) {
        Optional<Destination> description = destinationRepository.findById(id);
        if(!description.isPresent()) {
            throw new NotFoundException("Destination not found! ID: " + id);
        }
        return description.get();
    }

    public Destination findDestination(String name) {
        Optional<Destination> description = destinationRepository.findByName(name);
        if(!description.isPresent()) {
            throw new NotFoundException("Destination not found! Name: " + name);
        }
        return description.get();
    }

    public Destination addDestination(Destination destination, Hotel hotel) {
        destination.addHotel(hotel);
        destination = save(destination);
        return destination;
    }

    public Destination addDestination(Integer descriptionId, Integer hotelId) {
        return addDestination(findDestination(descriptionId), hotelService.findHotel(hotelId));
    }

    public Destination addDestination(Destination destination, Integer hotelId) {
        return addDestination(destination, hotelService.findHotel(hotelId));
    }

    public Destination updateDestination(Destination destination, Integer destinationId) {
        Destination destinationToUpdate = findDestination(destinationId);
        if(destination.getCountry() != null) {
            destinationToUpdate.setCountry(destination.getCountry());
        }
        if(destination.getName() != null) {
            destinationToUpdate.setName(destination.getName());
        }
        if(destination.getTemperature() != null) {
            destinationToUpdate.setTemperature(destination.getTemperature());
        }
        if(destination.getWeather() != null) {
            destinationToUpdate.setWeather(destination.getWeather());
        }
        if(destination.getHotels() != null && !destination.getHotels().isEmpty()) {
            destinationToUpdate.setHotels(destination.getHotels());
        }
        destinationToUpdate = save(destinationToUpdate);
        return destinationToUpdate;
    }

    public Set<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }
}
