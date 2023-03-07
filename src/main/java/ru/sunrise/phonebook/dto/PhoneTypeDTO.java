package ru.sunrise.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PhoneTypeDTO {
    private int id;
    private String typeName;
}