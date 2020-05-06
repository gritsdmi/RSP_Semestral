package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class HotelServiceTest {

    @Autowired
    public HotelService hotelService;

    @Autowired
    public UserService userService;

    @Autowired
    public TourService tourService;

    @Test
    public void addHotelTest() {
        Hotel hotel = Generator.generateHotel();
        assertNotNull(hotelService.save(hotel));

        Tour tour = Generator.generateTour();
        hotel = Generator.generateHotel();
        assertNotNull(hotelService.addHotel(hotel, tour));

        tour = tourService.save(Generator.generateTour());
        hotel = Generator.generateHotel();
        assertNotNull(hotelService.addHotel(hotel, tour.getId()));

        tour = tourService.save(Generator.generateTour());
        hotel = hotelService.save(Generator.generateHotel());
        assertNotNull(hotelService.addHotel(hotel.getId(), tour.getId()));

    }

    @Test
    public void getHotelTest() {
        Hotel hotel = Generator.generateHotel();
        hotelService.save(hotel);

        assertEquals(hotel, hotelService.findHotel(hotel.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeHotelTest() {
        Hotel hotel = Generator.generateHotel();
        hotelService.save(hotel);

        hotelService.remove(hotel);

        hotelService.findHotel(hotel.getId());
    }

    @Test(expected = NotFoundException.class)
    public void removeHotelByIdTest() {
        Hotel hotel = Generator.generateHotel();
        hotelService.save(hotel);

        hotelService.remove(hotel.getId());

        hotelService.findHotel(hotel.getId());
    }

    @Test
    public void getAllHotels() {
        Set<Hotel> hotels = hotelService.getAllHotels();

        hotels.add(hotelService.save(Generator.generateHotel()));
        hotels.add(hotelService.save(Generator.generateHotel()));
        hotels.add(hotelService.save(Generator.generateHotel()));

        assertEquals(hotels, hotelService.getAllHotels());
    }

}
