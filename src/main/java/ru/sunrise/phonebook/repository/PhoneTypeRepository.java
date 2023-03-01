package ru.sunrise.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.sunrise.phonebook.models.PhoneType;

import java.util.List;
import java.util.Optional;

public interface PhoneTypeRepository extends JpaRepository<PhoneType, Integer> {

    boolean existsByTypeName(String typeName);
}
