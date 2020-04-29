package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LocalAttraction extends AbstractEntity {

    private String address;

    private String description;

    private Integer distanceTo;

    private Boolean free;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Destination destination;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDistanceTo() {
        return distanceTo;
    }

    public void setDistanceTo(Integer distanceTo) {
        this.distanceTo = distanceTo;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
