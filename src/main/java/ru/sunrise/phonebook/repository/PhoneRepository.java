package ru.sunrise.phonebook.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sunrise.phonebook.models.Phone;
import ru.sunrise.phonebook.models.PhoneType;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    Optional<Phone> findPhoneByNumber(String number);

    boolean existsByNumber(String number);

}
