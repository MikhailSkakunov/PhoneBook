package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.models.PhoneType;

import java.util.List;

public interface PhoneTypeService {

    PhoneType update(PhoneType phoneType);
    PhoneType save(PhoneType phoneType);

//    void save(PhoneType phoneType);

    List<PhoneTypeDTO> findAll();

    PhoneTypeDTO findById(int id);

    void update(int id, PhoneType phoneType);

    void deleteById(int id);
}
