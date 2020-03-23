package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Excursion;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.repository.ExcursionRepository;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class ExcursionService {

    private final ExcursionRepository excursionRepository;

    private final TourService tourService;

    @Autowired
    public ExcursionService(ExcursionRepository excursionRepository, TourService tourService) {
        this.excursionRepository = excursionRepository;
        this.tourService = tourService;
    }

    public Excursion save(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    public Excursion findExcursion(Integer id) {
        Optional<Excursion> excursion = excursionRepository.findById(id);
        if(!excursion.isPresent()) {
            throw new NotFoundException("Excursion not found! ID: " + id);
        }
        return excursion.get();
    }

    public void remove(Integer id) {
        excursionRepository.deleteById(id);
    }

    public void remove(Excursion excursion) {
        excursionRepository.delete(excursion);
    }

    public Excursion addExcursion(Excursion excursion, Tour tour) {
        excursion.addTour(tour);
        excursion = save(excursion);
        return excursion;
    }

    public Excursion addExcursion(Excursion excursion, Integer tourId) {
        return addExcursion(excursion, tourService.findTour(tourId));
    }

    public Excursion addExcursion(Integer excursionId, Integer tourId) {
        return addExcursion(findExcursion(excursionId), tourService.findTour(tourId));
    }

    public Excursion updateExcursion(Excursion excursion, Integer excursionId) {
        Excursion excursionToUpdate = findExcursion(excursionId);
        if(excursion.getTransferNeeded() != null) {
            excursionToUpdate.setTransferNeeded(excursion.getTransferNeeded());
        }
        if(excursion.getArrivalTime() != null) {
            excursionToUpdate.setArrivalTime(excursion.getArrivalTime());
        }
        if(excursion.getDateFrom() != null) {
            excursionToUpdate.setDateFrom(excursion.getDateFrom());
        }
        if(excursion.getDateTill() != null) {
            excursionToUpdate.setDateTill(excursion.getDateTill());
        }
        if(excursion.getDepartureTime() != null) {
            excursionToUpdate.setDepartureTime(excursion.getDepartureTime());
        }
        if(excursion.getDescription() != null) {
            excursionToUpdate.setDescription(excursion.getDescription());
        }
        if(excursion.getName() != null) {
            excursionToUpdate.setName(excursion.getName());
        }
        if(excursion.getPrice() != null) {
            excursionToUpdate.setPrice(excursion.getPrice());
        }
        if(excursion.getTours() != null && !excursion.getTours().isEmpty()) {
            excursionToUpdate.setTours(excursion.getTours());
        }
        excursionToUpdate = save(excursionToUpdate);
        return excursionToUpdate;
    }
}
