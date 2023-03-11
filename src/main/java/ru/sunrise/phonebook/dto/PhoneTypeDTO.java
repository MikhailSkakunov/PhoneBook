package ru.sunrise.phonebook.dto;

import lombok.ToString;

import java.util.List;


@ToString
public class PhoneTypeDTO {

    private int id;

    private String typeName;

    private List<PhoneDTO> phonesDTO;

    public PhoneTypeDTO() {
    }

    public PhoneTypeDTO(int id, String typeName, List<PhoneDTO> phonesDTO) {
        this.id = id;
        this.typeName = typeName;
        this.phonesDTO = phonesDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<PhoneDTO> getPhonesDTO() {
        return phonesDTO;
    }

    public void setPhonesDTO(List<PhoneDTO> phonesDTO) {
        this.phonesDTO = phonesDTO;
    }
}