package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.LocalAttraction;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.repository.LocalAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class LocalAttractionService {

    private final LocalAttractionRepository localAttractionRepository;

    private final TourService tourService;

    @Autowired
    public LocalAttractionService(LocalAttractionRepository localAttractionRepository, TourService tourService) {
        this.localAttractionRepository = localAttractionRepository;
        this.tourService = tourService;
    }

    public LocalAttraction save(LocalAttraction localAttraction) {
        return localAttractionRepository.save(localAttraction);
    }

    public void remove(LocalAttraction localAttraction) {
        localAttractionRepository.delete(localAttraction);
    }

    public void remove(Integer id) {
        localAttractionRepository.deleteById(id);
    }

    public LocalAttraction findLocalAttraction(Integer id) {
        Optional<LocalAttraction> localAttraction = localAttractionRepository.findById(id);
        if(!localAttraction.isPresent()) {
            throw new NotFoundException("LocalAttractino not found! ID: " + id);
        }
        return localAttraction.get();
    }

    public LocalAttraction addLocalAttraction(LocalAttraction localAttraction, Tour tour) {
        localAttraction.addTour(tour);
        localAttraction = save(localAttraction);
        return localAttraction;
    }

    public LocalAttraction addLocalAttraction(Integer localAttractinoId, Integer tourId) {
        LocalAttraction localAttraction = findLocalAttraction(localAttractinoId);
        Tour tour = tourService.findTour(tourId);
        return addLocalAttraction(localAttraction, tour);
    }

    public LocalAttraction addLocalAttraction(LocalAttraction localAttraction, Integer tourId) {
        return addLocalAttraction(localAttraction, tourService.findTour(tourId));
    }

    public LocalAttraction updateLocalAttraction(LocalAttraction localAttraction, Integer id) {
        LocalAttraction localAttractionToUpdate = findLocalAttraction(id);

        if(localAttraction.getFree() != null) {
            localAttractionToUpdate.setFree(localAttraction.getFree());
        }
        if(localAttraction.getAddress() != null) {
            localAttractionToUpdate.setAddress(localAttraction.getAddress());
        }
        if(localAttraction.getDescription() != null) {
            localAttractionToUpdate.setDescription(localAttraction.getDescription());
        }
        if(localAttraction.getDistanceTo() != null) {
            localAttractionToUpdate.setDistanceTo(localAttraction.getDistanceTo());
        }
        if(localAttraction.getName() != null) {
            localAttractionToUpdate.setName(localAttraction.getName());
        }
        if(localAttraction.getTours() != null && !localAttraction.getTours().isEmpty()) {
            localAttractionToUpdate.setTours(localAttraction.getTours());
        }
        localAttractionToUpdate = save(localAttractionToUpdate);
        return localAttractionToUpdate;
    }
}
