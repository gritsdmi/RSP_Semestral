package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    Optional<Hotel> findByName(String name);
    Set<Hotel> findAll();
}
