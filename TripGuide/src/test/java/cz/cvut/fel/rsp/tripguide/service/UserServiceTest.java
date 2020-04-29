package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Autowired
    public TourService tourService;

    @Test
    public void regUserTest() {
        User createdUser = userService.regUser(Generator.generateUserDto());
        assertNotNull(createdUser);

        assertNotNull(userService.findUser(createdUser.getId()));
    }

    @Test
    public void getUserTest() {
        User user = userService.regUser(Generator.generateUserDto());
        assertNotNull(user);
        User get = userService.findUser(user.getId());
        assertEquals(user, get);
    }

    @Test
    public void getUserByNameTest() {
        User user = userService.regUser(Generator.generateUserDto());

        User get = userService.findUser(user.getUsername());
        assertEquals(user, get);
    }

    @Test(expected = NotFoundException.class)
    public void deleteUserByIdTest() {

        User user = userService.regUser(Generator.generateUserDto());
        int userId = user.getId();

        assertNotNull(user);

        userService.remove(userId);
        userService.findUser(userId);
    }

    @Test(expected = NotFoundException.class)
    public void deleteUserTest() {
        User user = userService.regUser(Generator.generateUserDto());

        userService.remove(user);

        userService.findUser(user.getId());
    }

    @Test
    public void getAllUsers() {
        Set<User> users = new HashSet<>();

        users.add(userService.save(Generator.generateUser()));
        users.add(userService.save(Generator.generateUser()));
        users.add(userService.save(Generator.generateUser()));

        assertEquals(users, userService.getAllUsers());
    }

    @Test
    public void getUsersByTour() {
        Tour tour = tourService.save(Generator.generateTour());
        Set<Tour> tours = new HashSet<>();
        tours.add(tour);

        User user = userService.save(Generator.generateUser());
        user.setTours(tours);
        userService.save(user);
        Set<User> users = new HashSet<>();
        users.add(user);

        Set<User> receivedUsers = userService.getTouristsByTour(tour);
        assertNotNull(receivedUsers);
        assertEquals(users, receivedUsers);
    }

    @Test
    public void addTourTest() {
        Tour tour = tourService.save(Generator.generateTour());
        User user = userService.save(Generator.generateUser());

        assertNotNull(userService.addTour(user, tour.getId()));

    }
}
