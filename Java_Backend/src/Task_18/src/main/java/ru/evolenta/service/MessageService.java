package ru.evolenta.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.evolenta.dto.Message;
import ru.evolenta.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getAllMessages() {
        return (List<Message>) repository.findAll();
    }

    public Optional<Message> findById(int id) {
        return repository.findById(id);
    }

    public Message save(Message message) {
        return repository.save(message);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    public Message getMessageForPerson(Integer id, Integer messageId) {
        return repository.findByIdAndPersonId(messageId, id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Message not found for user"));
    }
}