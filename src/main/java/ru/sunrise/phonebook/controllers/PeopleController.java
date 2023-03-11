package ru.sunrise.phonebook.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sunrise.phonebook.models.Address;
import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.service.PeopleService;
import ru.sunrise.phonebook.service.PhoneService;
import ru.sunrise.phonebook.service.PhoneTypeService;
import ru.sunrise.phonebook.service.StreetService;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final PhoneService phoneService;
    private final PhoneTypeService phoneTypeService;
    private final StreetService streetService;

    @Autowired
    public PeopleController(PeopleService peopleService, PhoneService phoneService, PhoneTypeService phoneTypeService, StreetService streetService) {
        this.peopleService = peopleService;
        this.phoneService = phoneService;
        this.phoneTypeService = phoneTypeService;
        this.streetService = streetService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "/people/show";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findById(id));
        model.addAttribute("phoneTypes", phoneTypeService.findAll());
        model.addAttribute("street", streetService.findAll());
        return "/people/info";
    }

    @GetMapping("/new")
    public String newPerson(Model model, Person person ) {
        model.addAttribute("person", person);
        model.addAttribute("phoneTypes", phoneTypeService.findAll());
        model.addAttribute("street", streetService.findAll());
        return "/people/new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("person") Person person,
                         @ModelAttribute("address") Address address,
                         @ModelAttribute("phone") Phone phone) {
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findById(id));
        model.addAttribute("street", streetService.findAll());
        model.addAttribute("phoneTypes", phoneTypeService.findAll());
        return "people/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {

        peopleService.update(id, person);
        return "redirect:/people";
    }

//    @GetMapping("/search")
//    public String findByFirstNameAndSurnameAndPatronymic(Model model,
//                                                         @ModelAttribute("person") PersonDTO personDTO) {
//        List<Person> people;
//        List<Person> personList = new ArrayList<>();
//
//        if ((person.getFirstName()) == null && (person.getSurname()) == null
//                && (person.getPatronymic()) == null) {
//            return "/people/search";
//        } else {
//                people = this.peopleService.findByFirstNameAndSurnameAndPatronymic(person.getFirstName(),
//                                person.getSurname(), person.getPatronymic())
//                        .orElseThrow(() -> new RuntimeException("Нет такого человека"));
//
//            for (Person p : people) {
//                Person pers = (peopleService.findById(p.getId()));
//                personList.add(pers);
//            }
//            model.addAttribute("people", personList);
//            return "/people/show_by_name";
//        }
//    }

    @GetMapping("/searchByPhone")
    public String findByPhones(Model model, @ModelAttribute("phone") Phone phone,
                               String number) {
        Phone phoneOwner;

        if ((phone.getNumber()) == null) {
            return "/people/search_phone";
        } else {
            phoneOwner = phoneService.findPhoneByNumber(number);
            model.addAttribute("person", peopleService.findById((phoneOwner.getOwner()).getId()));
            return "/people/info";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.deleteById(id);
        return "redirect:/people";
    }
}
