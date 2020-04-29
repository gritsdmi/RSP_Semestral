package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface EventRepository extends CrudRepository<Event, Integer> {
    Set<Event> findAllByTourOrderByIdDesc(Tour tour);
}
