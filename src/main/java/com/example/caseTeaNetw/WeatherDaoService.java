package com.example.caseTeaNetw;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class WeatherDaoService {
    private static List<Weather> weathers = new ArrayList<>();

    static{
        weathers.add(new Weather( "sunny" , "gebze", 3, DateTimeFormat.ISO.DATE_TIME));
        weathers.add(new Weather( "snowy" , "ist", 5, DateTimeFormat.ISO.DATE_TIME ));
        weathers.add(new Weather( "rainy" , "izmir", 8, DateTimeFormat.ISO.DATE_TIME));
    }

    public List<Weather> findAll(){
        return weathers;
    }
/*
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }*/
}
