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
@Table(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street_name", nullable = false)
    @NotEmpty
    private String streetName;

    @OneToMany(mappedBy = "street", orphanRemoval = true)
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();
}
