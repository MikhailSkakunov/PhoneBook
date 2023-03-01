package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.models.Street;

import java.util.List;

public interface PhoneTypeService {

    void save(PhoneType phoneType);

    List<PhoneType> findAll();

    PhoneType findById(int id);

    void update(int id, PhoneType phoneType);

    void deleteById(int id);
}
