package com.example.caseTeaNetw;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.*;

@RestController
public class WeatherResources {

    private WeatherDaoService service;

    public WeatherResources(WeatherDaoService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/weather")
    public List<Weather> retrieveAllweather() {
        return service.findAll();
    }

    @GetMapping("/weather/{date}")
    public Weather retrieveWeatherByDate(@PathVariable Integer date) {
        Weather weather = service.findByDate(date);
        if (date == null)
            throw new UserNotFoundException("Weather information for " + date + " is not found");
        return weather;
    }

    @GetMapping("/weather/{location}")
    public Weather retrieveWeatherByLocation(@PathVariable String location) {
        Weather weather = service.findByLocation(location);
        return weather;
    }

    @PostMapping("/weather")
    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {

        Weather savedWeather = service.save(weather);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{location}")
                .buildAndExpand(savedWeather.getLocation())
                .toUri();
        return ResponseEntity.created(location).build();


    }
}
