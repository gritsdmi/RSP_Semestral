package cz.cvut.fel.rsp.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private Time startTime; // time start for repeat event

    private Time endTime; // time end for repeat event

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private EventType type;

    @JsonIgnore
    @ManyToMany
    private Set<User> users = new HashSet<>();

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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int[] getDaysOfWeek() {
        return daysOfWeek;
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
}
