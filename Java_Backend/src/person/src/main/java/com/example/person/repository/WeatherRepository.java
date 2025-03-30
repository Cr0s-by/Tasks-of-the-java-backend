package com.example.person.repository;


import com.example.person.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByLatitudeAndLongitude(double latitude, double longitude);
}
