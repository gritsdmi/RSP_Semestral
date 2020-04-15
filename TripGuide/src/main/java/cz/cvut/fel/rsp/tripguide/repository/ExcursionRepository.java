package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Excursion;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ExcursionRepository extends CrudRepository<Excursion, Integer> {
    Set<Excursion> findByTours(Tour tour);
}
