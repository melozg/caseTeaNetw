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

    @GetMapping("/weather/byDate/{date}")
    public Weather retrieveWeatherByDate(@PathVariable Integer date) {
        Weather weather = service.findByDate(date);
        if (weather == null)
            throw new LocationNotFoundException("Weather information for " + date + " is not found");
        return weather;
    }


    @GetMapping("/weather/byLocation/{location}")
    public Weather retrieveWeatherByCondition(@PathVariable String location) {
        Weather weather = service.findByLocation(location);
        if (weather == null)
            throw new LocationNotFoundException("Weather information for " + location + " is not found");
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
