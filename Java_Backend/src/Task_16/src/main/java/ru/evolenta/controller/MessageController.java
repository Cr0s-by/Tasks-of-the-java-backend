package ru.evolenta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evolenta.dto.Message;
import ru.evolenta.service.MessageService;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Message> getAll() {
        return service.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return service.save(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable int id, @RequestBody Message message) {
        return service.findById(id)
                .map(existing -> {
                    message.setId(id);
                    return ResponseEntity.ok(service.save(message));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}