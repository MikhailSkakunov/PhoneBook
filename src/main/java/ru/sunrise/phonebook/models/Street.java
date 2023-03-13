package ru.sunrise.phonebook.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

    public Street() {
    }

    public Street(int id, String streetName, List<Address> addresses) {
        this.id = id;
        this.streetName = streetName;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
