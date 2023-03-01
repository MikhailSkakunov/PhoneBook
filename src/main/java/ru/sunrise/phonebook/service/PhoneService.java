package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.models.Phone;

import java.util.List;

public interface PhoneService {
    void save(Phone phone);

    Phone findPhoneByNumber(String number);

    boolean existsByNumber(String number);

    void deleteById(int id);

    void delete(Phone phones);
}
