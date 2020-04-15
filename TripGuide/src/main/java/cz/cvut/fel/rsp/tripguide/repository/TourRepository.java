package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

public interface TourRepository extends CrudRepository<Tour, Integer> {
    Set<Tour> findAll();
    Set<Tour> findAllByCity(String city);
}
