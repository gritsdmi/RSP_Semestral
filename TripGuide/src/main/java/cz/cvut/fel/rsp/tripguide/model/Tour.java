package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tour extends AbstractEntity {

    private String city;

    private String country;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime datTil;

    private String departureFrom;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime departureTime_start;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime departureTime_end;

    private String description;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private TourType tourType;

    @JsonIgnore
    @OneToOne
    private User delegate;

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @ManyToMany(mappedBy = "tours")
    private Set<LocalAttraction> localAttractions = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "tours")
    private Set<Excursion> excursions = new HashSet<>();

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

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDatTil() {
        return datTil;
    }

    public void setDatTil(LocalDateTime datTil) {
        this.datTil = datTil;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public LocalDateTime getDepartureTime_start() {
        return departureTime_start;
    }

    public void setDepartureTime_start(LocalDateTime departureTime_start) {
        this.departureTime_start = departureTime_start;
    }

    public LocalDateTime getDepartureTime_end() {
        return departureTime_end;
    }

    public void setDepartureTime_end(LocalDateTime departureTime_end) {
        this.departureTime_end = departureTime_end;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<LocalAttraction> getLocalAttractions() {
        return localAttractions;
    }

    public void setLocalAttractions(Set<LocalAttraction> localAttractions) {
        this.localAttractions = localAttractions;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
