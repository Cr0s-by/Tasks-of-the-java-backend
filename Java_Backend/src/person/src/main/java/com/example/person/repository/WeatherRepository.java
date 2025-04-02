package com.example.person.repository;


import com.example.person.model.Weather;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
    Optional<Weather> findByLatitudeAndLongitude(double latitude, double longitude);
}
