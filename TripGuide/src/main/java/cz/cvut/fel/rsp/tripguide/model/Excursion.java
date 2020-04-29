package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Excursion extends AbstractEntity {

    private LocalDateTime dateTimeFrom;

    private LocalDateTime dateTimeTill;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private String description;

    private String name;

    private Integer price;

    private Boolean transferNeeded;

    @JsonIgnore
    @ManyToMany
    private Set<Tour> tours = new HashSet<>();

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public LocalDateTime getDateTimeTill() {
        return dateTimeTill;
    }

    public void setDateTimeTill(LocalDateTime dateTimeTill) {
        this.dateTimeTill = dateTimeTill;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getTransferNeeded() {
        return transferNeeded;
    }

    public void setTransferNeeded(Boolean transferNeeded) {
        this.transferNeeded = transferNeeded;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public void addTour(Tour tour) {
        this.tours.add(tour);
    }
}
