package cz.cvut.fel.rsp.tripguide.repository;


import cz.cvut.fel.rsp.tripguide.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
