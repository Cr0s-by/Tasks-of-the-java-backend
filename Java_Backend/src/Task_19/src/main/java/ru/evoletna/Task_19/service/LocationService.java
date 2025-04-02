package ru.evoletna.Task_19.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evoletna.Task_19.model.Person;
import ru.evoletna.Task_19.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private PersonRepository personRepository;

    @Autowired
    public LocationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //список людей городе
    public List<Person> getPeopleByCity(String city) {
        return personRepository.findByLocationIgnoreCase(city);
    }
    // списко городов
    public Set<String> getAllCities() {
        Iterable<Person> allPeople = personRepository.findAll();

        List<Person> people = new ArrayList<>();
        allPeople.forEach(people::add);

        return people.stream()
                .map(Person::getLocation)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }
}
