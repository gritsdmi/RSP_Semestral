package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.dto.UserDto;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.*;
import cz.cvut.fel.rsp.tripguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
        return userRepository.findAllByTour(tour);
    }

    public Destination findUsersDestination(Integer id) {
        User user = findUser(id);
        return user.getTour() != null ? user.getTour().getHotel() != null ? user.getTour().getHotel().getDestination() : null : null;
    }

    public Hotel findUsersHotel(Integer id) {
        User user = findUser(id);
        return user.getTour() != null ? user.getTour().getHotel() : null;
    }
}
