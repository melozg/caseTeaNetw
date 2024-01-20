package com.example.caseTeaNetw;

import org.springframework.format.annotation.DateTimeFormat;

public class Weather {
    public Weather(String condition, String location, Integer temperature, DateTimeFormat.ISO timestamp) {
        this.condition = condition;
        Location = location;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    private String condition;
    private String Location;
    private Integer temperature ;
    private DateTimeFormat.ISO timestamp;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public DateTimeFormat.ISO getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTimeFormat.ISO timestamp) {
        this.timestamp = timestamp;
    }
}
