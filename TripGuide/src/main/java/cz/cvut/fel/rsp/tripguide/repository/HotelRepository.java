package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
}
