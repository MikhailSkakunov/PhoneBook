//package ru.sunrise.phonebook.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.sunrise.phonebook.dto.PersonDTO;
//import ru.sunrise.phonebook.mapstructmapper.MapStructMapper;
//import ru.sunrise.phonebook.service.PeopleService;
//import ru.sunrise.phonebook.service.PhoneService;
//import ru.sunrise.phonebook.service.PhoneTypeService;
//import ru.sunrise.phonebook.service.StreetService;
//
//@Controller
//@RequestMapping("/people")
//public class PeopleApiController {
//    private final PeopleService peopleService;
//    private final PhoneService phoneService;
//    private final PhoneTypeService phoneTypeService;
//    private final StreetService streetService;
//    private final MapStructMapper mapStructMapper;
//
//    @Autowired
//    public PeopleApiController(PeopleService peopleService, PhoneService phoneService,
//                               PhoneTypeService phoneTypeService, StreetService streetService,
//                               MapStructMapper mapStructMapper) {
//        this.peopleService = peopleService;
//        this.phoneService = phoneService;
//        this.phoneTypeService = phoneTypeService;
//        this.streetService = streetService;
//        this.mapStructMapper = mapStructMapper;
//    }
//
//    @GetMapping
//    public String showAll(Model model) {
//        model.addAttribute("people", peopleService.findAll());
//        return "/people/show";
//    }
//
//    @GetMapping("/{id}")
//    public String showById(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", peopleService.findById(id));
//        return "/people/info";
//    }

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
