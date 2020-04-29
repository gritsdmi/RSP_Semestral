package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tour extends AbstractEntity {

    private String city;

    private String country;

    private String departureFrom;

    private LocalDateTime dateTimeFrom;

    private LocalDateTime dateTimeTil;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private String description;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private TourType tourType;

    @JsonIgnore
    @ManyToOne
    private User delegate;

    @JsonIgnore
    @ManyToMany
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @ManyToMany(mappedBy = "tours")
    private Set<Excursion> excursions = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<Message> messages = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<Event> events = new HashSet<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public LocalDateTime getDateTimeTil() {
        return dateTimeTil;
    }

    public void setDateTimeTil(LocalDateTime dateTimeTil) {
        this.dateTimeTil = dateTimeTil;
    }


    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public User getDelegate() {
        return delegate;
    }

    public void setDelegate(User delegate) {
        this.delegate = delegate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
