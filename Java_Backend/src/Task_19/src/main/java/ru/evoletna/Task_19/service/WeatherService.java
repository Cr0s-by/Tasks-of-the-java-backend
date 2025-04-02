package ru.evoletna.Task_19.service;


import org.springframework.stereotype.Service;
import ru.evoletna.Task_19.model.Weather;
import ru.evoletna.Task_19.repository.WeatherRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Optional<Weather> getWeatherByCoordinates(Double latitude, Double longitude) {
        return weatherRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    public Weather addWeatherData(Double latitude, Double longitude,
                                  Double temperature, Double humidity,
                                  String description) {
        Weather weather = new Weather();
        weather.setLatitude(latitude);
        weather.setLongitude(longitude);
        weather.setTemperature(temperature);
        weather.setHumidity(humidity);
        weather.setDescription(description);
        weather.setTime(LocalDateTime.now());

        return weatherRepository.save(weather);
    }
}
