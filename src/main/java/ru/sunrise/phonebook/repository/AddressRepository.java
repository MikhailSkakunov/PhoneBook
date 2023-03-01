package ru.sunrise.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sunrise.phonebook.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
