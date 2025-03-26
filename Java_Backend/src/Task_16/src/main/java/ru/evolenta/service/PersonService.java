package ru.evolenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.evolenta.dto.Message;
import ru.evolenta.dto.Person;
import ru.evolenta.repository.PersonRepository;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person addMessageToPerson(int personId, Message message) {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "User not found with id: " + personId));

        message.setTime(LocalDateTime.now());
        message.setPerson(person);
        person.getMessages().add(message);
        return repository.save(person);
    }

    public void deleteMessageFromPerson(int personId, int messageId) {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Пользователь не найден"));

        boolean removed = person.getMessages().removeIf(m -> m.getId() == messageId);

        if (!removed) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Сообщение не найдено у пользователя");
        }

        repository.save(person);
    }

    public List<Message> getMessagesByPersonId(int personId) {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return person.getMessages();
    }

    public Message getMessageForPerson(int personId, int messageId) {
        return repository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"))
                .getMessages().stream()
                .filter(m -> m.getId() == messageId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
    }
}
