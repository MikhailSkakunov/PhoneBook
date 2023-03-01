package ru.sunrise.phonebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "phone_types")
public class PhoneType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name", nullable = false)
    @NotEmpty
    private String typeName;

    @OneToMany(mappedBy = "phoneType", orphanRemoval = true)
    @ToString.Exclude
    private List<Phone> phones = new ArrayList<>();
}