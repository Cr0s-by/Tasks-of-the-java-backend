package ru.evolenta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evolenta.dto.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
