package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hotel extends AbstractEntity {

    private String address;

    private Time breakfastTime_from;

    private Time breakfastTime_to;

    private Time dinnerTime_from;

    private Time dinnerTime_to;

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

    public Time getBreakfastTime_from() {
        return breakfastTime_from;
    }

    public void setBreakfastTime_from(Time breakfastTime_from) {
        this.breakfastTime_from = breakfastTime_from;
    }

    public Time getBreakfastTime_to() {
        return breakfastTime_to;
    }

    public void setBreakfastTime_to(Time breakfastTime_to) {
        this.breakfastTime_to = breakfastTime_to;
    }

    public Time getDinnerTime_from() {
        return dinnerTime_from;
    }

    public void setDinnerTime_from(Time dinnerTime_from) {
        this.dinnerTime_from = dinnerTime_from;
    }

    public Time getDinnerTime_to() {
        return dinnerTime_to;
    }

    public void setDinnerTime_to(Time dinnerTime_to) {
        this.dinnerTime_to = dinnerTime_to;
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
