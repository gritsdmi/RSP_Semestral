package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Message;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    Set<Message> findAllByTourOrderByIdDesc(Tour tour);
}
