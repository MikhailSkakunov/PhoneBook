package ru.sunrise.phonebook.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import ru.sunrise.phonebook.models.Street;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    void save(Street street);

    List<Street> findAll();

    Street findById(int id);

    void update(int id, Street street);

    void deleteById(int id);
}
