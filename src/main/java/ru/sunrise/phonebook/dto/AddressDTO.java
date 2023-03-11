package ru.sunrise.phonebook.dto;

import ru.sunrise.phonebook.models.Street;

public class AddressDTO {

    private int id;

    private String city;

    private String buildingNumber;

    private Integer ownerId;

    private StreetDTO streetDTO;

    public AddressDTO() {
    }

    public AddressDTO(int id, String city, String buildingNumber, Integer ownerId, StreetDTO streetDTO) {
        this.id = id;
        this.city = city;
        this.buildingNumber = buildingNumber;
        this.ownerId = ownerId;
        this.streetDTO = streetDTO;
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public StreetDTO getStreetDTO() {
        return streetDTO;
    }

    public void setStreetDTO(StreetDTO streetDTO) {
        this.streetDTO = streetDTO;
    }
}




