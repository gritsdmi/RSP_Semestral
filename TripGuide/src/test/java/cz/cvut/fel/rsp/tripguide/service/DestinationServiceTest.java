package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
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
public class DestinationServiceTest {

    @Autowired
    public DestinationService destinationService;

    @Autowired
    public HotelService hotelService;

    @Test
    public void createDestination() {
        Destination destination = Generator.generateDestination();
        assertEquals(destination, destinationService.save(destination));

        Hotel hotel = Generator.generateHotel();
        destination = Generator.generateDestination();
        assertNotNull(destinationService.addDestination(destination, hotel));

        hotel = hotelService.save(Generator.generateHotel());
        destination = destinationService.save(Generator.generateDestination());
        assertNotNull(destinationService.addDestination(destination.getId(), hotel.getId()));


        hotel = hotelService.save(Generator.generateHotel());
        destination = destinationService.save(Generator.generateDestination());
        assertNotNull(destinationService.addDestination(destination, hotel.getId()));
//        destination.addHotel(hotel);

    }

    @Test
    public void getDestinationTest() {
        Destination destination = Generator.generateDestination();
        assertNotNull(destinationService.save(destination));
        Destination tempDestination = destinationService.findDestination(destination.getId());
        assertEquals(destination, tempDestination);

        tempDestination = destinationService.findDestination(destination.getName());
        assertEquals(destination, tempDestination);

    }

    @Test(expected = NotFoundException.class)
    public void removeDestinationByIdTest() {
        Destination destination = Generator.generateDestination();
        assertNotNull(destinationService.save(destination));

        destinationService.remove(destination.getId());

        destinationService.findDestination(destination.getId());
    }

    @Test(expected = NotFoundException.class)
    public void removeDestinationTest() {
        Destination destination = Generator.generateDestination();
        assertNotNull(destinationService.save(destination));

        destinationService.remove(destination);

        destinationService.findDestination(destination.getId());
    }

    @Test
    public void getAllDestinations() {
        Set<Destination> destinations = new HashSet<>();

        destinations.add(destinationService.save(Generator.generateDestination()));
        destinations.add(destinationService.save(Generator.generateDestination()));
        destinations.add(destinationService.save(Generator.generateDestination()));

        assertEquals(destinations, destinationService.getAllDestinations());
    }


}
