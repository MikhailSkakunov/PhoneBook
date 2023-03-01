package ru.sunrise.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sunrise.phonebook.models.Person;

import java.util.List;
import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional <List<Person>> findByFirstNameAndSurnameAndPatronymic(String firstName, String surname, String patronymic);

}
