package cz.cvut.fel.rsp.tripguide.repository;

import cz.cvut.fel.rsp.tripguide.model.Destination;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface DestinationRepository extends CrudRepository<Destination, Integer> {

    Optional<Destination> findByName(String name);
    Set<Destination> findAll();
    Set<Destination> findAllByCountryIsContainingAndNameIsContaining(String countryRegex, String nameRegex);
}
