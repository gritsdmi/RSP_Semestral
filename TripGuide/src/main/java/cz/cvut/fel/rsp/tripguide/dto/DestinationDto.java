package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;

public class DestinationDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String country;

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
}
