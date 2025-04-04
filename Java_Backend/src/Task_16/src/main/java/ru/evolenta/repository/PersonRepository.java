package ru.evolenta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evolenta.dto.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}


