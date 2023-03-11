package ru.sunrise.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.dto.StreetDTO;
import ru.sunrise.phonebook.mapstructmapper.MapStructMapper;
import ru.sunrise.phonebook.models.Address;
import ru.sunrise.phonebook.models.Street;
import ru.sunrise.phonebook.repository.StreetRepository;
import ru.sunrise.phonebook.util.StreetAlreadyExistException;
import ru.sunrise.phonebook.util.StreetNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    private final MapStructMapper mapStructMapper;

    @Autowired
    public StreetServiceImpl(StreetRepository streetRepository, MapStructMapper mapStructMapper) {
        this.streetRepository = streetRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public List<StreetDTO> findAll() {
        List<Street> streets = streetRepository.findAll();
        List<StreetDTO> streetDTOS = mapStructMapper.streetsToListAllDto(streets);

        return streetDTOS;
    }

    @Override
    public StreetDTO findById(int id) {
        Street street = streetRepository.findById(id).orElseThrow(StreetNotFoundException::new);
        StreetDTO streetDTO = mapStructMapper.streetToStreetDTO(street);
        return streetDTO;
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