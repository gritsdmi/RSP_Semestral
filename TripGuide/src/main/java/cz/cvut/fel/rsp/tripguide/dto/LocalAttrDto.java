package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;

public class LocalAttrDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String description;
    @NotEmpty
    private String free;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }
}
