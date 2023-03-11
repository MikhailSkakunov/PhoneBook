package ru.sunrise.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.dto.PersonDTO;
import ru.sunrise.phonebook.dto.PersonMapper;
import ru.sunrise.phonebook.mapstructmapper.MapStructMapper;
import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.repository.PeopleRepository;
import ru.sunrise.phonebook.repository.PhoneRepository;
import ru.sunrise.phonebook.util.NameFieldsEmptyException;
import ru.sunrise.phonebook.util.PeopleNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;
    private final PhoneRepository phoneRepository;
    private final MapStructMapper mapStructMapper;
    private final PersonMapper personMapper;

    @Autowired
    public PeopleServiceImpl(PeopleRepository personRepository, PhoneRepository phoneRepository, MapStructMapper mapStructMapper, PersonMapper personMapper) {
        this.peopleRepository = personRepository;
        this.phoneRepository = phoneRepository;
        this.mapStructMapper = mapStructMapper;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> findAll() {
        return mapStructMapper.personsToListPersonsAllDto(peopleRepository.findAll());
    }

    @Override
    public Optional<List<Person>> findByFirstNameAndSurnameAndPatronymic(String firstName, String surname, String patronymic) {
        return peopleRepository.findByFirstNameAndSurnameAndPatronymic(firstName, surname, patronymic);
    }

    public PersonDTO findById(int id) {
        final Person person = peopleRepository.findById(id).orElseThrow(PeopleNotFoundException::new);
        final PersonDTO personDTO = personMapper.toPersonDTO(person);

        System.out.println("personDTO = " + personDTO);
        return personDTO;
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
        } else {
            for (Phone phone : person.getPhones()) {
                phone.setOwner(person);
            }
            person.getAddress().setOwner(person);
            person.getAddress().getStreet().setId(person.getAddress().getStreet().getId());
            peopleRepository.save(person);
        }
    }

    @Override
    @Transactional
    public void update(int id, Person person) {

        Person personUpdate = peopleRepository.findById(id).orElseThrow(PeopleNotFoundException::new);

        ArrayList<Phone> phones = (ArrayList<Phone>) person.getPhones();
        List<Phone> phonesUpdate = new ArrayList<>(personUpdate.getPhones());

            for (int i = 0; i < phones.size(); i++) {
                if (phones.get(i).getNumber().isEmpty()) {
                    phones.remove(phones.get(i));
                }
            }

        for (Phone ph : phonesUpdate) {
            for (Phone p : phones)  {
                if (!ph.getNumber().equals(p.getNumber())) {
                    phoneRepository.deleteById(ph.getId());
                }
            }
        }

        personUpdate.setFirstName(person.getFirstName());
        personUpdate.setSurname(person.getSurname());
        personUpdate.setPatronymic(person.getPatronymic());
        personUpdate.getAddress().setCity(person.getAddress().getCity());
        personUpdate.getAddress().setBuildingNumber(person.getAddress().getBuildingNumber());
        personUpdate.getAddress().setStreet(person.getAddress().getStreet());
        person.getAddress().setOwner(personUpdate);



        for (Phone ph : phones) {
            ph.setOwner(personUpdate);
        }

        for (Phone phone : phonesUpdate) {
            phones.removeIf(p -> phone.getNumber().equals(p.getNumber()));
        }
        phones.removeIf(p -> p.getNumber().isEmpty());

        phoneRepository.saveAll(phones);

        peopleRepository.save(personUpdate);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        peopleRepository.deleteById(id);
    }
//    @Override
//    @Transactional
//    public void phoneUpdateSizeTrue(int id, Person person) {
//        Person personUpdate = peopleRepository.findById(id)
//                .orElseThrow(PeopleNotFoundException::new);
//        ArrayList<Phone> phones = (ArrayList<Phone>) person.getPhones();
//        List<Phone> phonesUpdate = new ArrayList<>(personUpdate.getPhones());
//
//        ArrayList<Phone> newPones = new ArrayList<>();
//        for (Phone phone : phonesUpdate) {
//            for (int j = 0; j < phones.size(); j++) {
//                if (!(phone.getNumber()).equals(phones.get(j).getNumber())) {
//                    newPones.add(phone);
//                }
//            }
//            phoneRepository.deleteAll(phonesUpdate);
//            phones.clear();
//            phoneRepository.saveAll(newPones);
//        }
//    }
//
//    @Override
//    @Transactional
//    public void phoneUpdateSizeFalse(int id, Person person) {
//        Person personUpdate = peopleRepository.findById(id)
//                .orElseThrow(PeopleNotFoundException::new);
//        ArrayList<Phone> phones = (ArrayList<Phone>) person.getPhones();
//        List<Phone> phonesUpdate = new ArrayList<>(personUpdate.getPhones());
//        ArrayList<Phone> newPones = new ArrayList<>();
//
//        for (Phone phone : phonesUpdate) {
//            for (int j = 0; j < phones.size(); j++) {
//                if ((phone.getNumber().equals(phones.get(j).getNumber()))) {
//                    phones.remove(phones.get(j));
//                }
//            }
//            newPones.addAll(phones);
//            newPones.addAll(phonesUpdate);
//            for (Phone p : newPones) {
//                if (p.getOwner() == null) {
//                p.setOwner(personUpdate);
//                }
//            }
//            phoneRepository.saveAll(newPones);
//        }
//    }
}
