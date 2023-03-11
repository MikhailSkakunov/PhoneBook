package ru.sunrise.phonebook.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sunrise.phonebook.models.Street;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface StreetMapper {

    Street toStreet(StreetDTO streetDTO);

    @InheritInverseConfiguration
    StreetDTO toStreetDTO(Street street);


}
