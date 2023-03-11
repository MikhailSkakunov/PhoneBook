package ru.sunrise.phonebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    public Person() {
    }

    public Person(int id, String firstName, String surname, String patronymic, Address address, List<Phone> phones) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
