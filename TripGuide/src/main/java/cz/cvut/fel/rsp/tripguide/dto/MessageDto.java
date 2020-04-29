package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotEmpty;

public class MessageDto {
    @NotEmpty
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
