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
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "surname", nullable = false)
    @NotEmpty
    private String surname;

    @Column(name = "patronymic", nullable = false)
    @NotEmpty
    private String patronymic;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Address address = new Address();

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Phone> phones = new ArrayList<>();
}
