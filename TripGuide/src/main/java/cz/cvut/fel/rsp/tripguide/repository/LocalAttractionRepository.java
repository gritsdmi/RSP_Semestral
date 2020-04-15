package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.LocalAttraction;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface LocalAttractionRepository extends CrudRepository<LocalAttraction, Integer> {
    Set<LocalAttraction> findAllByDestinationOrderByIdDesc(Destination destination);
}
