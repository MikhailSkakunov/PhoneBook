package ru.sunrise.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sunrise.phonebook.dto.PhoneTypeDTO;
import ru.sunrise.phonebook.models.PhoneType;
import ru.sunrise.phonebook.service.PhoneTypeService;

import java.util.List;

@Controller
@RequestMapping("/type")
public class PhoneTypeController {

    private final PhoneTypeService phoneTypeService;

    @Autowired
    public PhoneTypeController(PhoneTypeService phoneTypeService) {
        this.phoneTypeService = phoneTypeService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("types", phoneTypeService.findAll());
        return "/type/show";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<PhoneTypeDTO> listAll() {
        return phoneTypeService.findAll();
    }

    @ResponseBody
    @GetMapping("/map")
    public List<PhoneTypeDTO> mapAll() {
        return phoneTypeService.findAll();
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("type", phoneTypeService.findById(id));
        return "/type/info";
    }

    @GetMapping("/new")
    public String newPhoneType(Model model) {
        model.addAttribute("type", new PhoneType());
        return "/type/new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("type") PhoneType phoneType) {
        phoneTypeService.save(phoneType);
        return "redirect:/type";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("type", phoneTypeService.findById(id));
        return "type/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("type") PhoneTypeDTO phoneTypeDTO,
                         @PathVariable("id") int id) {

        phoneTypeService.update(id, phoneTypeDTO);
        return "redirect:/type";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        phoneTypeService.deleteById(id);
        return "redirect:/type";
    }
}
