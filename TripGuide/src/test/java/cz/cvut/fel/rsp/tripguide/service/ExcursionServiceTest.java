package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Excursion;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class ExcursionServiceTest {

    @Autowired
    public ExcursionService excursionService;

    @Autowired
    public TourService tourService;

    @Test
    public void addExcursionTest() {
        Excursion excursion = Generator.generateExcursion();
        assertNotNull(excursionService.save(excursion));

        Tour tour = Generator.generateTour();
        excursion = Generator.generateExcursion();
        assertNotNull(excursionService.addExcursion(excursion, tour));

        tour = tourService.save(Generator.generateTour());
        excursion = Generator.generateExcursion();
        assertNotNull(excursionService.addExcursion(excursion, tour.getId()));

        tour = tourService.save(Generator.generateTour());
        excursion = excursionService.save(Generator.generateExcursion());
        assertNotNull(excursionService.addExcursion(excursion.getId(), tour.getId()));

    }

    @Test
    public void getExcursionTest() {
        Excursion excursion = Generator.generateExcursion();
        excursionService.save(excursion);

        assertEquals(excursion, excursionService.findExcursion(excursion.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeExcursionTest() {
        Excursion excursion = Generator.generateExcursion();
        excursionService.save(excursion);

        excursionService.remove(excursion);

        excursionService.findExcursion(excursion.getId());
    }
}
