package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

//updated event model for calendar!
@Entity
public class Event extends AbstractEntity {

    private String title; // event title

    private LocalDateTime start; // event start date and time

    private LocalDateTime end; // event end date and time

    private int[] daysOfWeek; // days when repeat [1,2,3,4,5,6,7] == [monday, ...]

    private LocalDate startRecur; // date start for repeat event

    private LocalDate endRecur; // date end for repeat event

    private LocalTime startTime; // time start for repeat event

    private LocalTime endTime; // time end for repeat event

    private boolean regular;

    @ManyToOne
    private Tour tour;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private EventType type;

    @JsonIgnore
    @ManyToMany
    private Set<User> users = new HashSet<>();

    @Transient
    private StringBuilder daysString = new StringBuilder();

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public String getDaysString() {
        if (daysOfWeek != null) {
            for (int dayInt : daysOfWeek) {
                if (dayInt == 1) daysString.append("Mon ");
                if (dayInt == 2) daysString.append("Tue ");
                if (dayInt == 3) daysString.append("Wed ");
                if (dayInt == 4) daysString.append("Thu ");
                if (dayInt == 5) daysString.append("Fri ");
                if (dayInt == 6) daysString.append("Sat ");
                if (dayInt == 7) daysString.append("Sun ");
            }
            return daysString.toString();
        }
        return "";
    }

    public void setDaysOfWeek(int[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public LocalDate getStartRecur() {
        return startRecur;
    }

    public void setStartRecur(LocalDate startRecur) {
        this.startRecur = startRecur;
    }

    public LocalDate getEndRecur() {
        return endRecur;
    }

    public void setEndRecur(LocalDate endRecur) {
        this.endRecur = endRecur;
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
    public void removeUser(User user) {
        this.users.remove(user);
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

}
