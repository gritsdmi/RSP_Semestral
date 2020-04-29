package cz.cvut.fel.rsp.tripguide.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.temporal.ChronoUnit;

@Entity
public class Message extends AbstractEntity {

    private String text;

    @ManyToOne
    private Tour tour;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getCreateDate() {
        return getCreatedat().truncatedTo(ChronoUnit.MINUTES).toString().replace('T', ' ');
    }
}
