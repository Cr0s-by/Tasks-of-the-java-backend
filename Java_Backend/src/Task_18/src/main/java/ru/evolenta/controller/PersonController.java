package ru.evolenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.evolenta.dto.Message;
import ru.evolenta.dto.Person;
import ru.evolenta.repository.PersonRepository;
import ru.evolenta.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository repository;
    private final PersonService service;

    public PersonController(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return (List<Person>) repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person savedPerson = repository.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id,  @RequestBody Person person) {
        return repository.findById(id)
                .map(existing -> {
                    person.setId(id);
                    return ResponseEntity.ok(repository.save(person));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/message")
    public ResponseEntity<?> addMessage(@PathVariable int id, @RequestBody Message message) {
        try {
            Person updatedPerson = service.addMessageToPerson(id, message);
            return ResponseEntity.ok(updatedPerson);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}/message/{messageId}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id, @PathVariable int messageId) {
        try {
            service.deleteMessageFromPerson(id, messageId);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @GetMapping("/{id}/message")
    public ResponseEntity<List<Message>> getMessagesByPerson(@PathVariable int id) {
        try {
            List<Message> messages = service.getMessagesByPersonId(id);
            return ResponseEntity.ok(messages);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

}