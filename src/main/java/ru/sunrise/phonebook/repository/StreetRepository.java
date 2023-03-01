package ru.sunrise.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sunrise.phonebook.models.Street;

public interface StreetRepository extends JpaRepository<Street, Integer> {

    boolean existsByStreetName(String streetName);
}
