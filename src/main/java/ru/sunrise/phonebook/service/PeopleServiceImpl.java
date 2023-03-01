package ru.sunrise.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.repository.PeopleRepository;
import ru.sunrise.phonebook.repository.PhoneRepository;
import ru.sunrise.phonebook.util.NameFieldsEmptyException;
import ru.sunrise.phonebook.util.PeopleNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    private final PhoneRepository phoneRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository personRepository, PhoneRepository phoneRepository) {
        this.peopleRepository = personRepository;
        this.phoneRepository = phoneRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public Optional<List<Person>> findByFirstNameAndSurnameAndPatronymic(String firstName, String surname, String patronymic) {
        return peopleRepository.findByFirstNameAndSurnameAndPatronymic(firstName, surname, patronymic);
    }

    public Person findById(int id) {
            return peopleRepository.findById(id).orElseThrow(PeopleNotFoundException::new);
    }

    @Override
    @Transactional
    public void save(Person person) {
        if (person.getFirstName().isEmpty() || person.getSurname().isEmpty()
                || person.getPatronymic().isEmpty()
                || (person.getAddress().getStreet()).getStreetName().isEmpty()
                || (person.getAddress().getBuildingNumber()).isEmpty()
                || (person.getAddress().getCity()).isEmpty()) {
            throw new NameFieldsEmptyException();

//        } else if(!person.getPhones().isEmpty()) {
//            for (Phone phone : person.getPhones()) {
//                (phoneRepository.findPhoneByNumber(phone.getNumber())).equals(phone.getNumber());
//            } throw new PhoneNumberAlreadyExist();
//
//        } else if(!person.getPhones().isEmpty()) {
//                phoneRepository.existsByNumber(person.getPhones().getNumber());
//            }
//        throw new PhoneNumberAlreadyExist();

        } else {
            for (Phone phone : person.getPhones()) {
                phone.setOwner(person);
            }
            person.getAddress().setOwner(person);
            peopleRepository.save(person);
        }
    }

    @Override
    @Transactional
    public void update(int id, Person person) {

        Person personUpdate = peopleRepository.findById(id)
                .orElseThrow(PeopleNotFoundException::new);

        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setSurname(person.getSurname());
        personUpdate.setPatronymic(person.getPatronymic());
        personUpdate.getAddress().setCity(person.getAddress().getCity());
        personUpdate.getAddress().setBuildingNumber(person.getAddress().getBuildingNumber());
        personUpdate.getAddress().setStreet(person.getAddress().getStreet());
        personUpdate.getAddress().setOwner(personUpdate);

        peopleRepository.save(personUpdate); //здесь я возвращаю чела по id сечу из формы все изменения ФИО и адреса и сохраняю. Все ОК

        ArrayList<Phone> phones = (ArrayList<Phone>) person.getPhones();

        List<Phone> phDelete = personUpdate.getPhones();
        phoneRepository.deleteAll(phDelete);

        List<Phone> phUpdate = new ArrayList<>(phones.size());
        for (int i = 0; i < phones.size(); i++) {
            phUpdate.add(new Phone());
        }

        Collections.copy(phUpdate, phones);

            for (Phone p:phUpdate) {
                p.setOwner(personUpdate);
                System.out.println(p);
            }
            phoneRepository.saveAll(phUpdate);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
//        Address address = peopleRepository.findById(id).get().getAddress();
//        address.setOwner(null);
//        address.setStreet(null);
//        address.setBuildingNumber(null);
        peopleRepository.deleteById(id);
    }
}
