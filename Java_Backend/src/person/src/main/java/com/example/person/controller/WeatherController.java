package com.example.person.controller;


import com.example.person.model.Weather;
import com.example.person.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @Value("${openweather.api.key}")
    private String apiKey;

    @GetMapping
    public Weather getWeather(@RequestParam double lat, @RequestParam double lon) {
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric&lang=ru",
                lat, lon, apiKey
        );

        Weather response = repository.getForObject(url, Weather.class);

        return mapToWeather(response);
    }

    private Weather mapToWeather(Weather response) {
        Weather weather = new Weather();
        weather.setTemp(response.getTemp());
        weather.setDescription(response.getDescription());
        weather.setHumidity(response.getHumidity());
        weather.setSpeed(response.getSpeed());
        return weather;
    }

}