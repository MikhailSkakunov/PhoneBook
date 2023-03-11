package ru.sunrise.phonebook.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sunrise.phonebook.models.PhoneType;

@Mapper(componentModel = "spring", uses = PhoneMapper.class)
public interface PhoneTypeMapper {

    PhoneType toPhoneType(PhoneTypeDTO phoneTypeDTO);

    @InheritInverseConfiguration
    PhoneTypeDTO toPhoneTypeDTO(PhoneType phoneType);
}
