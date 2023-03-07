package ru.sunrise.phonebook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.repository.PhoneTypeRepository;
import ru.sunrise.phonebook.util.PhoneTypeAlreadyExistException;
import ru.sunrise.phonebook.util.PhoneTypeNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PhoneTypeServiceImpl implements PhoneTypeService {

    private final PhoneTypeRepository phoneTypeRepository;

    @Override
    public List<PhoneType> findAll() {
        return phoneTypeRepository.findAll();
    }

    @Override
    public PhoneType findById(int id) {
        return phoneTypeRepository.findById(id).orElseThrow(PhoneTypeNotFoundException::new);
    }

    @Override
    @Transactional
    public PhoneType update(PhoneType phoneType) {
        return phoneTypeRepository.save(phoneType);
    }

    @Override
    @Transactional
    public PhoneType save(PhoneType phoneType) {
        if (phoneTypeRepository.existsByTypeName(phoneType.getTypeName()))
            throw new PhoneTypeAlreadyExistException();
        return phoneTypeRepository.save(phoneType);
    }

    @Override
    @Transactional
    public void update(int id, PhoneType phoneType) {
        if (phoneTypeRepository.existsByTypeName(phoneType.getTypeName())) {
            phoneTypeRepository.save(phoneType);
        } else throw new PhoneTypeAlreadyExistException();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        List<Phone> phones = phoneTypeRepository.findById(id)
                .orElseThrow(PhoneTypeNotFoundException::new)
                .getPhones();
        for (Phone p:phones) {
            p.setPhoneType(null);
        }
        phoneTypeRepository.deleteById(id);
    }
}
