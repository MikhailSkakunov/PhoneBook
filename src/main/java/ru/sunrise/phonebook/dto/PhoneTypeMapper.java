package ru.sunrise.phonebook.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sunrise.phonebook.models.PhoneType;

@Mapper(componentModel = "spring", uses = PhoneMapper.class)
public interface PhoneTypeMapper {

//    @Mapping(target = "typeName", source = "typeName")
//    @Mapping(target = "phones", source = "phonesDTO")
    PhoneType toPhoneType(PhoneTypeDTO source);

    @InheritInverseConfiguration
//    @Mapping(target = "typeName", source = "typeName")
//    @Mapping(target = "phonesDTO", source = "phones")
    PhoneTypeDTO toPhoneTypeDTO(PhoneType source);
}
