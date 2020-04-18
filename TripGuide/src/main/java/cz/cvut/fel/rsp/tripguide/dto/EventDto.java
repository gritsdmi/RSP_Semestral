package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotNull;

public class EventDto {

    private Integer id;

    private String title;

    private String start;

    private String end;

    private int[] daysOfWeek;

    private String startRecur;

    private String endRecur;

    private String startTime;

    private String endTime;

    private String url;

    private String color;

    private String textColor;

    private Boolean overlap;

    private ExtendedProps extendedProps;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(int[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getStartRecur() {
        return startRecur;
    }

    public void setStartRecur(String startRecur) {
        this.startRecur = startRecur;
    }

    public String getEndRecur() {
        return endRecur;
    }

    public void setEndRecur(String endRecur) {
        this.endRecur = endRecur;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public Boolean getOverlap() {
        return overlap;
    }

    public void setOverlap(Boolean overlap) {
        this.overlap = overlap;
    }

    public ExtendedProps getExtendedProps() {
        return extendedProps;
    }

    public void setExtendedProps(ExtendedProps extendedProps) {
        this.extendedProps = extendedProps;
    }
}
