package cz.cvut.fel.rsp.tripguide.repository;


import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    Set<User> findAllByTour(Tour tour);

    Set<User> findAll();
}
