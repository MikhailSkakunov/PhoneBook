package ru.sunrise.phonebook.service;

import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.dto.PersonDTO;
import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.models.Street;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PeopleService {

    List<PersonDTO> findAll();

    Optional<List<Person>> findByFirstNameAndSurnameAndPatronymic(String firstName, String surname, String patronymic);

    PersonDTO findById(int id);

    void save(Person person);

    void save(PersonDTO personDTO);

    void update(int id, Person person);

    void deleteById(int id);

//    void phoneUpdateSizeTrue(int id, Person person);
//
//    void phoneUpdateSizeFalse(int id, Person person);
}
