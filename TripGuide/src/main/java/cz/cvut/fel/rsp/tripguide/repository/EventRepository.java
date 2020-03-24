package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
