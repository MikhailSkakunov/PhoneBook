package ru.sunrise.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.mapstructmapper.MapStructMapper;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.repository.PhoneTypeRepository;
import ru.sunrise.phonebook.util.PhoneTypeAlreadyExistException;
import ru.sunrise.phonebook.util.PhoneTypeNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PhoneTypeServiceImpl implements PhoneTypeService {

    private final PhoneTypeRepository phoneTypeRepository;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public PhoneTypeServiceImpl(PhoneTypeRepository phoneTypeRepository, MapStructMapper mapStructMapper) {
        this.phoneTypeRepository = phoneTypeRepository;
        this.mapStructMapper = mapStructMapper;
    }


    @Override
    public List<PhoneTypeDTO> findAll() {
        List<PhoneType> phoneTypes = phoneTypeRepository.findAll();
        List<PhoneTypeDTO> phoneTypeDTOS = mapStructMapper.phoneTypesToListAllDto(phoneTypes);

        return phoneTypeDTOS;
    }

    @Override
    public PhoneTypeDTO findById(int id) {
        PhoneType phoneType = phoneTypeRepository.findById(id).orElseThrow(PhoneTypeNotFoundException::new);
        PhoneTypeDTO phoneTypeDTO = mapStructMapper.phoneTypeToPhoneTypeDTO(phoneType);
        return phoneTypeDTO;
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
