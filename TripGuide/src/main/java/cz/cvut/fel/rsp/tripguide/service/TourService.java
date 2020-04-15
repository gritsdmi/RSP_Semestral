package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@SuppressWarnings("ALL")
@Service
public class TourService {

    private final TourRepository tourRepository;

    private final UserService userService;

    @Autowired
    public TourService(TourRepository tourRepository, UserService userService) {
        this.tourRepository = tourRepository;
        this.userService = userService;
    }

    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour findTour(Integer id) {
        Optional<Tour> tour = tourRepository.findById(id);
        if(!tour.isPresent()) {
            throw new NotFoundException("Tour not found! ID: " + id);
        }
        return tour.get();
    }

    public Set<Tour> findToursByCityName(String cityName) {
        return tourRepository.findAllByCity(cityName);
    }

    public void remove(Integer id) {
        this.tourRepository.deleteById(id);
    }

    public void remove(Tour tour) {
        this.tourRepository.delete(tour);
    }

    public Tour addTour(Tour tour, User user) {
        tour.addUser(user);
        tour = save(tour);
        return tour;
    }

    public Tour addTour(Tour tour, Integer userId) {
        User user = userService.findUser(userId);
        tour.addUser(user);
        tour = save(tour);
        return tour;
    }

    public Tour addTour(Integer tourId, Integer userId) {
        Tour tour = findTour(tourId);
        User user = userService.findUser(userId);
        tour.addUser(user);
        tour = save(tour);
        return tour;
    }

    public Tour updateTour(Tour tour, Integer tourId) {
        Tour tourToUpdate = findTour(tourId);
        if(tour.getCity() != null) {
            tourToUpdate.setCity(tour.getCity());
        }
        if(tour.getCountry() != null) {
            tourToUpdate.setCountry(tour.getCountry());
        }
        if(tour.getDateFrom() != null) {
            tourToUpdate.setDateFrom(tour.getDateFrom());
        }
        if(tour.getDatTil() != null) {
            tourToUpdate.setDatTil(tour.getDatTil());
        }
        if(tour.getDelegate() != null) {
            tourToUpdate.setDelegate(tour.getDelegate());
        }
        if(tour.getDepartureFrom() != null) {
            tourToUpdate.setDepartureFrom(tour.getDepartureFrom());
        }
        if(tour.getDepartureTime_end() != null) {
            tourToUpdate.setDepartureTime_end(tour.getDepartureTime_end());
        }
        if(tour.getDepartureTime_start() != null) {
            tourToUpdate.setDepartureTime_start(tour.getDepartureTime_start());
        }
        if(tour.getDescription() != null) {
            tourToUpdate.setDescription(tour.getDescription());
        }
        if(tour.getExcursions() != null && !tour.getExcursions().isEmpty()) {
            tourToUpdate.setExcursions(tour.getExcursions());
        }
        if(tour.getHotel() != null) {
            tourToUpdate.setHotel(tour.getHotel());
        }
//        if(tour.getLocalAttractions() != null) {
//            tourToUpdate.setLocalAttractions(tour.getLocalAttractions());
//        }
        if(tour.getTourType() != null) {
            tourToUpdate.setTourType(tour.getTourType());
        }
        if(tour.getTransferType() != null) {
            tourToUpdate.setTransferType(tour.getTransferType());
        }
        if(tour.getUsers() != null && !tour.getUsers().isEmpty()) {
            tourToUpdate.setUsers(tour.getUsers());
        }
        tour = save(tour);
        return tour;
    }

    public Set<Tour> getAllTours() {
        return tourRepository.findAll();
    }
}
