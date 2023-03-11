package ru.sunrise.phonebook.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@ToString
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city", nullable = false)
    @NotEmpty
    private String city;

    @Column(name = "building_number")
    private String buildingNumber;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ToString.Exclude
    private Person owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    @ToString.Exclude
    private Street street;

    public Address() {
    }

    public Address(int id, String city, String buildingNumber, Person owner, Street street) {
        this.id = id;
        this.city = city;
        this.buildingNumber = buildingNumber;
        this.owner = owner;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
