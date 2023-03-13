package ru.sunrise.phonebook.controllers;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sunrise.phonebook.dto.StreetDTO;
import ru.sunrise.phonebook.models.Street;
import ru.sunrise.phonebook.service.StreetService;

@Controller
@RequestMapping("/street")
public class StreetController {

    private final StreetService streetService;
    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("streets", streetService.findAll());
        return "/street/show";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("street", streetService.findById(id));
        return "/street/info";
    }

    @GetMapping("/new")
    public String newStreet(Model model) {
        model.addAttribute("street", new Street());
        return "/street/new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("street") Street street) {
        streetService.save(street);
        return "redirect:/street";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("street", streetService.findById(id));
        return "street/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("street") StreetDTO streetDTO,
                       @PathVariable("id") int id) {
        streetService.update(id, streetDTO);
        return "redirect:/street";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        streetService.deleteById(id);
        return "redirect:/street";
    }
}
