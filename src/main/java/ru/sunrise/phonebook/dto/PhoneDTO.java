package ru.sunrise.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PhoneDTO {

    private int id;

    private String number;
}
