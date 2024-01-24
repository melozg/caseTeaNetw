package com.example.caseTeaNetw;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name="weather_details")
public class Weather {

    protected Weather(){

    }

    @Id
    private Long id;

    public Weather(String condition, String location, Integer temperature, LocalDate date) {
        this.condition = condition;
        this.location = location;
        this.temperature = temperature;
        this.date = date;
    }

    private String condition;
    private String location;
    private Integer temperature ;
    private LocalDate date;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
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

    public LocalDate getDate() {
        return date;
    }

//    public void setTimestamp(DateTimeFormat.ISO timestamp) {
//        this.timestamp = timestamp;
//    }

    public void setTimestamp(LocalDate date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
