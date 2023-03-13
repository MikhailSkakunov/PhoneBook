package ru.sunrise.phonebook.service;

import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.models.PhoneType;

import java.util.List;

public interface PhoneTypeService {

    void save(PhoneType phoneType);

    List<PhoneTypeDTO> findAll();

    PhoneTypeDTO findById(int id);

    void update(int id, PhoneTypeDTO phoneType);

    void deleteById(int id);
}
