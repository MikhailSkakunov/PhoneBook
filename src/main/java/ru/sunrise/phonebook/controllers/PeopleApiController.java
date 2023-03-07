//package ru.sunrise.phonebook.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import ru.sunrise.phonebook.dto.PersonDTO;
//import ru.sunrise.phonebook.models.Person;
//import ru.sunrise.phonebook.service.PeopleService;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/people")
//public class PeopleApiController {
//    private final PeopleService service;
//
//    @GetMapping
//    public List<PersonDTO> listAll() {
//        return service.findAll().stream().map(
//                (e) -> new PersonDTO(e.getId(), e.getFirstName(), e.getSurname() , e.getPatronymic())
//        ).collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public PersonDTO getById(@PathVariable("id") int id) {
//        Person entity = service.findById(id);
//        return new PersonDTO(entity.getId(), entity.getFirstName(), entity.getSurname(), entity.getPatronymic(), entity.getAddressDTO(), entity.getPhones());
//    }
//
//    @PostMapping
//    public PersonDTO create(@RequestBody PersonDTO dto) {
//        Person entity = new Person();
//
//        entity.setFirstName(dto.getFirstName());
//        entity.setSurname(dto.getSurname());
//        entity.setPatronymic(dto.getPatronymic());
//        entity = service.save(entity);
//
//        return new PersonDTO(entity.getId(), entity.getFirstName(), entity.getSurname(), entity.getPatronymic());
//    }
//
//    @PutMapping("/{id}")
//    public PersonDTO update(@PathVariable("id") int id, @RequestBody PersonDTO dto) {
//        Person entity = service.findById(id);
//
//        entity.setFirstName(dto.getFirstName());
//        entity.setSurname(dto.getSurname());
//        entity.setPatronymic(dto.getPatronymic());
//        entity = service.update(entity);
//
//        return new PersonDTO(entity.getId(), entity.getFirstName(), entity.getSurname(), entity.getPatronymic());
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") int id) {
//        service.deleteById(id);
//    }
//}
