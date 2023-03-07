package ru.sunrise.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {

    private int id;

    private String city;

    private String buildingNumber;
}
