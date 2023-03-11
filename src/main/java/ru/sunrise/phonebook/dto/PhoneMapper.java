package ru.sunrise.phonebook.dto;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.sunrise.phonebook.models.Phone;

@Mapper(componentModel = "spring", uses = {PhoneTypeMapper.class})
public interface PhoneMapper {

    PersonMapper INSTANCE = (PersonMapper) Mappers.getMapper(PhoneMapper.class);

    @Mapping(target = "phoneType.id", ignore = true)
    @Mapping(target = "owner.id", ignore = true)
    Phone toPhone(PhoneDTO phoneDTO);

    @InheritInverseConfiguration
    @Mapping(target = "phoneTypeDTO", source = "phoneType")
    @Mapping(target = "ownerId", source = "owner.id")
    PhoneDTO toPhoneDTO(Phone phone, @Context Phone phoneType);
}
