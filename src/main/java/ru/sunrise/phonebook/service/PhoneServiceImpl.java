package ru.sunrise.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.repository.PhoneRepository;
import ru.sunrise.phonebook.util.PhoneNumberNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public Phone findPhoneByNumber(String number) {
        return phoneRepository.findPhoneByNumber(number)
                .orElseThrow(PhoneNumberNotFoundException::new);
    }

    @Override
    public boolean existsByNumber(String number) {
        return true;
    }

    @Override
    @Transactional
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        phoneRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Phone phones) {

    }
}
