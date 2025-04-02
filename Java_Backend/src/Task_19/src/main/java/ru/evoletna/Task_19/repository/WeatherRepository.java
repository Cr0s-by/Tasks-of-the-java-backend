package ru.evoletna.Task_19.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evoletna.Task_19.model.Weather;

import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
    Optional<Weather> findByLatitudeAndLongitude(Double latitude, Double longitude);
}
