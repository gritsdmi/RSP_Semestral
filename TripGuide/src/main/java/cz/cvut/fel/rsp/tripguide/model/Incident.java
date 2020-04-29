package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Incident extends AbstractEntity {

    private String description;

    @JsonIgnore
    @ManyToOne
    private User tourist;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getTourist() {
        return tourist;
    }

    public void setTourist(User tourist) {
        this.tourist = tourist;
    }
}
