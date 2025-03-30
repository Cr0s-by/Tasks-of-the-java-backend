package com.example.person.controller;


import com.example.person.model.City;
import com.example.person.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityRepository repository;

    @GetMapping
    public List<City> getAllCities() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return repository.save(city);
    }
}