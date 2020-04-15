package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;

public class TourDto {

    private String country;
    private String city;
    private String dateFrom;
    private String dateTil;
    private String departureFrom;
    private String departureTime_start;
    private String departureTime_end;

    @NotEmpty
    private String description;
    @NotEmpty
    private String hotel;

    private String delegate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTil() {
        return dateTil;
    }

    public void setDateTil(String dateTil) {
        this.dateTil = dateTil;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getDepartureTime_start() {
        return departureTime_start;
    }

    public void setDepartureTime_start(String departureTime_start) {
        this.departureTime_start = departureTime_start;
    }

    public String getDepartureTime_end() {
        return departureTime_end;
    }

    public void setDepartureTime_end(String departureTime_end) {
        this.departureTime_end = departureTime_end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }
}
