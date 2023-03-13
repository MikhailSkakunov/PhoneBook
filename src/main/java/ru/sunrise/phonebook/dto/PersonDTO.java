package ru.sunrise.phonebook.dto;

import lombok.*;

import java.util.List;


public class PersonDTO {

    private int id;

    private String firstName;

    private String surname;

    private String patronymic;

    private AddressDTO addressDTO;

    private List<PhoneDTO> phonesDTO;

    public PersonDTO() {
    }

    public PersonDTO(int id, String firstName, String surname, String patronymic, AddressDTO addressDTO, List<PhoneDTO> phonesDTO) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.addressDTO = addressDTO;
        this.phonesDTO = phonesDTO;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public List<PhoneDTO> getPhonesDTO() {
        return phonesDTO;
    }

    public void setPhonesDTO(List<PhoneDTO> phonesDTO) {
        this.phonesDTO = phonesDTO;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", addressDTO=" + addressDTO +
                ", phonesDTO=" + phonesDTO +
                '}';
    }
}
