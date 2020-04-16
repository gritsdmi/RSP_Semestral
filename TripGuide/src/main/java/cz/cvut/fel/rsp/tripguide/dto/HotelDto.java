package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;
import java.sql.Time;

public class HotelDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phoneNumbrer;
    @NotEmpty
    private String stars;
    @NotEmpty
    private String web;
    @NotEmpty
    private String destination;
    @NotEmpty
    private String breakfastTime_from;
    @NotEmpty
    private String breakfastTime_to;
    @NotEmpty
    private String dinnerTime_from;
    @NotEmpty
    private String dinnerTime_to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumbrer() {
        return phoneNumbrer;
    }

    public void setPhoneNumbrer(String phoneNumbrer) {
        this.phoneNumbrer = phoneNumbrer;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBreakfastTime_from() {
        return breakfastTime_from;
    }

    public void setBreakfastTime_from(String breakfastTime_from) {
        this.breakfastTime_from = breakfastTime_from;
    }

    public String getBreakfastTime_to() {
        return breakfastTime_to;
    }

    public void setBreakfastTime_to(String breakfastTime_to) {
        this.breakfastTime_to = breakfastTime_to;
    }

    public String getDinnerTime_from() {
        return dinnerTime_from;
    }

    public void setDinnerTime_from(String dinnerTime_from) {
        this.dinnerTime_from = dinnerTime_from;
    }

    public String getDinnerTime_to() {
        return dinnerTime_to;
    }

    public void setDinnerTime_to(String dinnerTime_to) {
        this.dinnerTime_to = dinnerTime_to;
    }
}
