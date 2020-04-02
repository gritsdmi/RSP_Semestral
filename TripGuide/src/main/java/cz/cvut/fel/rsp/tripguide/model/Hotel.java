package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hotel extends AbstractEntity {

    private String address;

    private Time breakfastTime;

    private Time dinnerTime;

    private String email;

    private String name;

    private Integer stars;

    private String phoneNumber;

    private String web;

    @JsonIgnore
    @ManyToOne
    private Destination destination;

    @JsonIgnore
    @OneToOne(mappedBy = "hotel")
    private Tour tour;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDinnerTime(Time dinnerTime) {
        this.dinnerTime = dinnerTime;
    }

    public Time getDinnerTime() {
        return dinnerTime;
    }

    public Time getBreakfastTime() {
        return breakfastTime;
    }

    public void setBreakfastTime(Time breakfastTime) {
        this.breakfastTime = breakfastTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
