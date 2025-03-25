package ru.evolenta.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.test.dto.Message;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "BMW", "Red", LocalDate.of(1999, 2, 3)),
            new Message(2, "Audi", "Black", LocalDate.of(2010, 3, 8)),
            new Message(3, "Mercedes", "Blue", LocalDate.of(1999, 12, 7)),
            new Message(4, "Lada", "White", LocalDate.of(2001, 4, 16))
    ));

    @PostMapping("/message")
    public ResponseEntity<Message> setMessage(@RequestBody Message message) {
        messages.add(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/message")
    public Iterable<Message> getMessages() {
        return messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = -1;
        for (Message p : messages) {
            if (p.getId() == id) {
                index = messages.indexOf(p);
                messages.set(index, message);
            }
        }
        return index == -1 ? addMessage(message) : message;
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }
}