package com.example.caseTeaNetw;

import org.springframework.format.annotation.DateTimeFormat;

public class Weather {
    public Weather(String condition, String location, Integer temperature, Integer date) {
        this.condition = condition;
        this.Location = location;
        this.temperature = temperature;
        this.date = date;
    }

    private String condition;
    private String Location;
    private Integer temperature ;

    //private DateTimeFormat.ISO timestamp;
    private Integer date;

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

//    public DateTimeFormat.ISO getTimestamp() {
//        return timestamp;
//    }
    // LocalDateTime.now()

    public Integer getDate() {
        return date;
    }

//    public void setTimestamp(DateTimeFormat.ISO timestamp) {
//        this.timestamp = timestamp;
//    }

    public void setTimestamp(Integer date) {
        this.date = date;
    }
}
