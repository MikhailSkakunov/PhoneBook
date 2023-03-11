package ru.sunrise.phonebook.dto;

import lombok.ToString;



@ToString
public class PhoneDTO {

    private int id;

    private String number;

    private PhoneTypeDTO phoneTypeDTO;

    private Integer ownerId;

    public PhoneDTO() {
    }

    public PhoneDTO(int id, String number, PhoneTypeDTO phoneTypeDTO, Integer ownerId) {
        this.id = id;
        this.number = number;
        this.phoneTypeDTO = phoneTypeDTO;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneTypeDTO getPhoneTypeDTO() {
        return phoneTypeDTO;
    }

    public void setPhoneTypeDTO(PhoneTypeDTO phoneTypeDTO) {
        this.phoneTypeDTO = phoneTypeDTO;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
