package com.example.caseTeaNetw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class WeatherResources {

    private WeatherDaoService service;
    public WeatherResources(WeatherDaoService service){
        this.service = service;
    }

    //GET /users
    @GetMapping("/weather")
    public List<Weather> retrieveAllweather(){
        return service.findAll();
    }

//    @GetMapping("/weather/{location}")
//    public List<Weather> retrieveAllweather() {
//        return service.findAll();
//    }
}
