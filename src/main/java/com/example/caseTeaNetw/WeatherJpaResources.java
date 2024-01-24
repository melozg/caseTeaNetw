package com.example.caseTeaNetw;

import com.example.caseTeaNetw.jpa.WeatherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class WeatherJpaResources {

    private WeatherDaoService service;

    private WeatherRepository repository;

    public WeatherJpaResources(WeatherDaoService service, WeatherRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    //GET /users
    @GetMapping("/jpa/weather")
    public List<Weather> retrieveAllweather() {
        return repository.findAll();
    }

    @GetMapping("/jpa/weather/byDate/{date}")
    public List<Weather> retrieveWeatherByDate(@PathVariable LocalDate date) {
        List<Weather> weather = repository.findByDate(date);
        if (weather.isEmpty())
            throw new LocationNotFoundException("Weather information for " + date + " is not found");
        return weather;
    }


    @GetMapping("/jpa/weather/byLocation/{location}")
    public List<Weather> retrieveWeatherByLocation(@PathVariable String location) {
        List<Weather> weather = repository.findByLocation(location);
        if (weather.isEmpty())
            throw new LocationNotFoundException("Weather information for " + location + " is not found");
        return weather;
    }

    @PostMapping("/jpa/weather")
    public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {

        Weather savedWeather = repository.save(weather);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{location}")
                .buildAndExpand(savedWeather.getLocation())
                .toUri();
        return ResponseEntity.created(location).build();


    }
}
