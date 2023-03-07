package ru.sunrise.phonebook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.service.PhoneTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/type")
public class PhoneTypeApiController {
    private final PhoneTypeService service;

    @GetMapping
    public List<PhoneTypeDTO> listAll() {
        return service.findAll().stream().map(
                (e) -> new PhoneTypeDTO(e.getId(), e.getTypeName())
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PhoneTypeDTO getById(@PathVariable("id") int id) {
        PhoneType entity = service.findById(id);
        return new PhoneTypeDTO(entity.getId(), entity.getTypeName());
    }

    @PostMapping
    public PhoneTypeDTO create(@RequestBody PhoneTypeDTO dto) {
        PhoneType entity = new PhoneType();

        entity.setTypeName(dto.getTypeName());
        entity = service.save(entity);

        return new PhoneTypeDTO(entity.getId(),entity.getTypeName());
    }

    @PutMapping("/{id}")
    public PhoneTypeDTO update(@PathVariable("id") int id, @RequestBody PhoneTypeDTO dto) {
        PhoneType entity = service.findById(id);

        entity.setTypeName(dto.getTypeName());
        entity = service.update(entity);

        return new PhoneTypeDTO(entity.getId(), entity.getTypeName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
