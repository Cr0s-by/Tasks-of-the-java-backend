package ru.evolenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.dto.Message;
import ru.evolenta.dto.Person;
import ru.evolenta.repository.MessageRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class MessageController {

    private MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/message")
    public List<Message> getAllMessage() {
        return (List<Message>) repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        repository.save(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return repository.findById(id)
                .map(existingMessage -> {
                    existingMessage.setTitle(message.getTitle());
                    existingMessage.setText(message.getText());
                    existingMessage.setTime(message.getTime());

                    Message updatedMessage = repository.save(existingMessage);
                    return ResponseEntity.ok(updatedMessage);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        repository.deleteById(id);
    }
}