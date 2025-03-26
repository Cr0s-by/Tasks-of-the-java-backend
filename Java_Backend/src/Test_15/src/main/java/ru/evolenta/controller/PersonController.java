package ru.evolenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.dto.Person;
import ru.evolenta.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonController {

    private PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return (List<Person>) repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        repository.save(person);
        return person;
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        return repository.findById(id)
                .map(existingPerson -> {
                    // Обновляем поля существующей записи
                    existingPerson.setFirstname(person.getFirstname());
                    existingPerson.setSurname(person.getSurname());
                    existingPerson.setLastname(person.getLastname());
                    existingPerson.setBirthday(person.getBirthday());

                    Person updatedPerson = repository.save(existingPerson);
                    return ResponseEntity.ok(updatedPerson);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}