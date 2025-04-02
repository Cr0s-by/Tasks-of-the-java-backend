package ru.evoletna.Task_19.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evoletna.Task_19.model.Person;
import ru.evoletna.Task_19.service.LocationService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public Set<String> getAllCities() {
        return locationService.getAllCities();
    }

    @GetMapping("/{city}/people")
    public List<Person> getPeopleInCity(@PathVariable String city) {
        return locationService.getPeopleByCity(city);
    }

}
