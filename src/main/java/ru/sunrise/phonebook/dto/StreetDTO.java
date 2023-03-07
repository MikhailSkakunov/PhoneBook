package ru.sunrise.phonebook.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StreetDTO {

    private int id;

    private String streetName;
}
