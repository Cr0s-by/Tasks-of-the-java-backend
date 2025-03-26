package ru.evolenta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evolenta.dto.Message;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByPersonId(Integer personId);

    Optional<Message> findByIdAndPersonId(Integer id, Integer personId);
}
