package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TourDto {
    @NotNull
    @NotEmpty
    private String departureFrom;
    @NotNull
    @NotEmpty
    private String dateTimeFrom;
    @NotNull
    @NotEmpty
    private String dateTimeTil;
    @NotNull
    @NotEmpty
    private String departureDateTime;
    @NotNull
    @NotEmpty
    private String arrivalDateTime;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private String hotel;
    @NotNull
    @NotEmpty
    private String delegate;

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(String dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public String getDateTimeTil() {
        return dateTimeTil;
    }

    public void setDateTimeTil(String dateTimeTil) {
        this.dateTimeTil = dateTimeTil;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
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
