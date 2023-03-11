package ru.sunrise.phonebook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.mapstructmapper.MapStructMapper;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.service.PhoneTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/type")
public class PhoneTypeApiController {
    private final PhoneTypeService service;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public PhoneTypeApiController(PhoneTypeService service, MapStructMapper mapStructMapper) {
        this.service = service;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping
    public List<PhoneTypeDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PhoneTypeDTO getById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PostMapping
    public PhoneTypeDTO create(@RequestBody PhoneTypeDTO dto) {

        PhoneType phoneType = mapStructMapper.phoneTypeDtoToPhoneType(dto);
        service.save(phoneType);

        return mapStructMapper.phoneTypeToPhoneTypeDTO(phoneType);
    }

    @PutMapping("/{id}")
    public PhoneTypeDTO update(@PathVariable("id") int id, @RequestBody PhoneTypeDTO dto) {
         PhoneTypeDTO phoneTypeDTO = service.findById(id);
         PhoneType phoneType = mapStructMapper.phoneTypeDtoToPhoneType(phoneTypeDTO);

         phoneType.setTypeName(phoneTypeDTO.getTypeName());
         service.update(phoneType);

        return phoneTypeDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
