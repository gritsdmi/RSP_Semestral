package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Destination extends AbstractEntity {

    private String name;

    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private Set<Hotel> hotels = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private Set<LocalAttraction> localAttractions = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public Set<LocalAttraction> getLocalAttractions() {
        return localAttractions;
    }

    public void setLocalAttractions(Set<LocalAttraction> localAttractions) {
        this.localAttractions = localAttractions;
    }

    @Override
    public String toString() {
        return this.name + " " + this.country;
    }
}
