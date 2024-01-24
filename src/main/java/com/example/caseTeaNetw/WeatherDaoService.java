package com.example.caseTeaNetw;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class WeatherDaoService {
    private static List<Weather> weathers = new ArrayList<>();

//    static{
//        weathers.add(new Weather( "sunny" , "gebze", 3, 6));
//        weathers.add(new Weather( "snowy" , "ist", 5, 7 ));
//        weathers.add(new Weather( "rainy" , "izmir", 8, 18));
//    }

    public List<Weather> findAll(){
        return weathers;
    }

    public Weather save(Weather weather) {

        weathers.add(weather);
        return weather;
    }

    public Weather findByLocation(String location) {
        Predicate<? super Weather> predicate = weather -> weather.getLocation().equals(location);
        return weathers.stream().filter(predicate).findFirst().orElse(null);
    }

    public Weather findByDate(Integer time) {
        Predicate<? super Weather> predicate = weather -> weather.getDate().equals(time);
        return weathers.stream().filter(predicate).findFirst().orElse(null);
    }

//    public Weather findByLocationAndDate(DateTimeFormat.ISO time, String location ) {
//        Predicate<? super Weather> predicate = weather -> weather.getLocation().equals(location) ;
//        Predicate<? super Weather> predicate2 = weather -> weather.getDate().equals(time) ;
//        return weathers.stream().filter(predicate).findFirst().orElse(null);
//
//    }


}
