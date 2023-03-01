package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Street;

import java.util.List;
import java.util.Optional;

public interface PeopleService {

    List<Person> findAll();

    Optional<List<Person>> findByFirstNameAndSurnameAndPatronymic(String firstName, String surname, String patronymic);

    Person findById(int id);

    void save(Person person);

    void update(int id, Person person);

    void deleteById(int id);

}
