package cz.cvut.fel.rsp.tripguide.dto;

import javax.validation.constraints.NotNull;

public class EventDto {

    private String title;

    private String start;

    private String end;

    private int[] daysOfWeek;

    private String startRecur;

    private String endRecur;

    private String startTime;

    private String endTime;

    private String url;

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
}
