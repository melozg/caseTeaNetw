package com.example.caseTeaNetw.jpa;

import com.example.caseTeaNetw.EndUsers;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.caseTeaNetw.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findByDate(LocalDate date);
    List<Weather> findByLocation(String location);

}
