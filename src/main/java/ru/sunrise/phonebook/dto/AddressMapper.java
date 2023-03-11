package ru.sunrise.phonebook.dto;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.sunrise.phonebook.models.Address;

@Mapper(componentModel = "spring", uses = {StreetMapper.class})
public interface AddressMapper {

//    PersonMapper INSTANCE = (PersonMapper) Mappers.getMapper(AddressMapper.class);


    @Mapping(target = "owner.id", source = "ownerId")
    @Mapping(target = "street", source = "streetDTO")
    Address toAddress(AddressDTO addressDTO);

    @InheritInverseConfiguration
    @Mapping(target = "streetDTO", source = "street")
    @Mapping(target = "ownerId", source = "owner.id")
    AddressDTO toAddressDTO(Address address);
}
