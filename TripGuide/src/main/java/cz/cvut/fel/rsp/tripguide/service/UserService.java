package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.dto.EventDto;
import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.*;
import cz.cvut.fel.rsp.tripguide.repository.UserRepository;
import cz.cvut.fel.rsp.tripguide.util.CalendarEventConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TourService tourService;

    @Autowired
    private EventService eventService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userFindByUserName = userRepository.findByUsername(s);
        if(userFindByUserName != null) {
            return userFindByUserName;
        }
        return userRepository.findByEmail(s);
    }

    public User regUser(UserDto registration) {
        User user = new User();
        user.setActive(true);
        user.setFullName(registration.getFullName());
        user.setUsername(registration.getUsername());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Collections.singleton(Role.TOURIST));
        user = save(user);
        return user;
    }

    public User addMessage(Integer userId, Integer messageId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            return null;
        }
        return null;
    }

    public User findUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException("User not found! ID: " + id);
        }
        return user.get();
    }

    public User findUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundException("User not found! Username: " + username);
        }
        return user;
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(User user) {
        userRepository.delete(user);
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    public Set<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Set<User> getTouristsByTour(Tour tour){
        return userRepository.findAllByToursContains(tour);
    }

    public Set<User> getTouristsByEvent(Event event){
        return userRepository.findAllByEventsContains(event);
    }

    public Set<Destination> findUsersDestinations(Integer id) {
        return findUser(id).getTours()
                .stream()
                .map(Tour::getHotel)
                .map(Hotel::getDestination)
                .collect(Collectors.toSet());
    }

    public Set<Hotel> findUsersHotel(Integer id) {
        return findUser(id).getTours()
                .stream()
                .map(Tour::getHotel)
                .collect(Collectors.toSet());
    }

    public User addTour(User user, Integer tour) {
        Tour t = tourService.findTour(tour);
        t.addUser(user);
        t = tourService.save(t);
        user.addTour(t);
        return save(user);
    }

    public User addEvent(User user, Event event) {
        event.addUser(user);
        event = eventService.save(event);
        user.addEvent(event);
        return save(user);
    }

    public User removeEvent(User user, Event event) {
        event.removeUser(user);
        event = eventService.save(event);
        user.removeEvent(event);
        return save(user);
    }

    public Set<EventDto> generateUserEvents(Integer id) {
        CalendarEventConvertor cec = new CalendarEventConvertor();
        Set<EventDto> events = new HashSet<>();
        User user = findUser(id);

        Set<Tour> tours = user.getTours();

        Set<Excursion> excs = tours.stream()
                .map(Tour::getExcursions)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        events.addAll(tours.stream()
                .map(cec::convert)
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));

        events.addAll(excs.stream()
                .map(cec::convert)
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));

        events.addAll(tours.stream()
                .map(Tour::getHotel)
                .map(cec::convert)
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));

        events.addAll(user.getEvents()
                .stream()
                .map(cec::convert)
                .collect(Collectors.toSet()));

        return events;
    }
}