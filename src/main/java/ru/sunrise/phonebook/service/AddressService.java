package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.models.Address;
import ru.sunrise.phonebook.models.Person;

public interface AddressService {

    void save(Address address);

    void saveOwner();


}
