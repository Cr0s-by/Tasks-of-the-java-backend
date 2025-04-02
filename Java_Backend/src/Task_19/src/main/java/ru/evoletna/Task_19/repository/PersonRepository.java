package ru.evoletna.Task_19.repository;

import org.springframework.data.repository.CrudRepository;
import ru.evoletna.Task_19.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findByLocationIgnoreCase(String location);
}
