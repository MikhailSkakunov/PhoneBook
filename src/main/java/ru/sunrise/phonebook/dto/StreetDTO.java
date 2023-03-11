package ru.sunrise.phonebook.dto;


import lombok.ToString;

import java.util.List;

@ToString
public class StreetDTO {

    private int id;

    private String streetName;

    private List<AddressDTO> addressesDTO;

    public StreetDTO() {
    }

    public StreetDTO(int id, String streetName, List<AddressDTO> addressesDTO) {
        this.id = id;
        this.streetName = streetName;
        this.addressesDTO = addressesDTO;
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

    public List<AddressDTO> getAddressesDTO() {
        return addressesDTO;
    }

    public void setAddressesDTO(List<AddressDTO> addressesDTO) {
        this.addressesDTO = addressesDTO;
    }
}
