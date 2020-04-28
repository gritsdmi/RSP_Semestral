package cz.cvut.fel.rsp.tripguide;


import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.model.*;

import java.util.Collections;
import java.util.Random;

public class Generator {

    private final static Random random = new Random();
    private static int counter = 0;

    public static int randomInt() {
        return Math.abs(random.nextInt() % 1000);
    }

    public static boolean randomBool() {
        return random.nextBoolean();
    }

    public static User generateUser() {
        UserDto userDto = generateUserDto();
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setRoles(Collections.singleton(Role.TOURIST));
        user.setFullName(userDto.getFullName());
        user.setId(randomInt());

        return user;
    }

    public static UserDto generateUserDto() {
        UserDto user = new UserDto();
        user.setEmail("Email" + ++counter + "@test.com");
        user.setPassword(String.valueOf(randomInt()));
        user.setUsername("user" + counter);
        user.setFullName("fullNameTemplate" + counter);
        return user;
    }

    public static Destination generateDestination() {
        Destination destination = new Destination();
        destination.setCountry("Country Name" + randomInt());
        destination.setName("Destination Name" + randomInt());
        return destination;
    }

    public static Hotel generateHotel() {
        Hotel hotel = new Hotel();
        hotel.setAddress("Hotel address template" + randomInt());
        hotel.setName("Hotel name" + randomInt());
        return hotel;
    }

    public static Tour generateTour() {
        Tour tour = new Tour();
        tour.setCity("City" + randomInt());
        tour.setCountry("Country Name" + randomInt());
        return tour;
    }

    public static Event generateEvent() {
        Event event = new Event();
        event.setType(EventType.EXCURTION);
        event.setTitle("Event title" + randomInt());
        return event;
    }

    public static Excursion generateExcursion() {
        Excursion excursion = new Excursion();
        excursion.setDescription("Excursion description is here" + randomInt());
        excursion.setName("Excursion name" + randomInt());

        return excursion;
    }

    public static Incident generateIncident() {
        Incident incident = new Incident();
        incident.setDescription("Incident description" + randomInt());
//        incident.setTourist(generateUser());
        return incident;
    }

    public static LocalAttraction generateLocalAttraction() {
        LocalAttraction localAttraction = new LocalAttraction();
        localAttraction.setFree(true);
        localAttraction.setDescription("Description attraction" + randomInt());
        return localAttraction;
    }


}
