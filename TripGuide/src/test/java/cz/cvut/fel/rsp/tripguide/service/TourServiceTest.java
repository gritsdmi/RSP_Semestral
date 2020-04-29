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
public class TourServiceTest {

    @Autowired
    public TourService tourService;

    @Autowired
    public UserService userService;

    @Test
    public void createTourTest() {

        Tour tour = Generator.generateTour();
        assertEquals(tour, tourService.save(tour));

        User user = Generator.generateUser();
        tour = Generator.generateTour();
        assertNotNull(tourService.addTour(tour, user));

        user = userService.save(Generator.generateUser());
        tour = Generator.generateTour();
        assertNotNull(tourService.addTour(tour, user.getId()));

        tour = tourService.save(Generator.generateTour());
        user = userService.save(Generator.generateUser());
        assertNotNull(tourService.addTour(tour.getId(), user.getId()));

    }

    @Test(expected = NotFoundException.class)
    public void removeTourTest() {
        Tour tour = Generator.generateTour();
        tourService.save(tour);

        tourService.remove(tour);

        tourService.findTour(tour.getId());

    }

    @Test
    public void getTour() {
        Tour tour = Generator.generateTour();
        tourService.save(tour);

        Tour receivedTour = tourService.findTour(tour.getId());

        assertEquals(tour, receivedTour);
    }

    @Test(expected = NotFoundException.class)
    public void removeTourByIdTest() {
        Tour tour = Generator.generateTour();
        tourService.save(tour);

        tourService.remove(tour.getId());

        tourService.findTour(tour.getId());

    }

    @Test
    public void getAllTours() {
        Set<Tour> tours = new HashSet<>();

        tours.add(tourService.save(Generator.generateTour()));
        tours.add(tourService.save(Generator.generateTour()));
        tours.add(tourService.save(Generator.generateTour()));

        assertEquals(tours, tourService.getAllTours());
    }

}
