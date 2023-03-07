package ru.sunrise.phonebook.dto;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDTO {

    private int id;

    private String firstName;

    private String surname;

    private String patronymic;

    private AddressDTO addressDTO;

    private List<PhoneDTO> phonesDTO;
}
