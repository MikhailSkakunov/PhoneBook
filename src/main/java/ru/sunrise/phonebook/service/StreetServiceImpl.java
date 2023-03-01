package ru.sunrise.phonebook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.models.Address;
import ru.sunrise.phonebook.models.Street;
import ru.sunrise.phonebook.repository.StreetRepository;
import ru.sunrise.phonebook.util.StreetAlreadyExistException;
import ru.sunrise.phonebook.util.StreetNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;


    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Override
    public Street findById(int id) {
        return streetRepository.findById(id).orElseThrow(StreetNotFoundException::new);
    }

    @Override
    @Transactional
    public void save(Street street) {
        if (!streetRepository.existsByStreetName(street.getStreetName())) {
            streetRepository.save(street);
        } else throw new StreetAlreadyExistException();
    }

    @Override
    @Transactional
    public void update(int id, Street street) {
        if (!streetRepository.existsByStreetName(street.getStreetName())) {
            streetRepository.save(street);
        } else throw new StreetAlreadyExistException();
}

    @Override
    @Transactional
    public void deleteById(int id) {
        List<Address> addresses = streetRepository.findById(id)
                .orElseThrow(StreetNotFoundException::new)
                .getAddresses();
        for (Address a:addresses) {
            a.setStreet(null);
        }
            streetRepository.deleteById(id);
    }
}