package ru.evoletna.Task_19.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evoletna.Task_19.model.Weather;
import ru.evoletna.Task_19.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<Weather> getWeather(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {

        return weatherService.getWeatherByCoordinates(latitude, longitude)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Weather> addWeatherData(
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double temperature,
            @RequestParam Double humidity,
            @RequestParam String description) {

        Weather newWeather = weatherService.addWeatherData(
                latitude, longitude,
                temperature, humidity, description);

        return new ResponseEntity<>(newWeather, HttpStatus.CREATED);
    }
}
