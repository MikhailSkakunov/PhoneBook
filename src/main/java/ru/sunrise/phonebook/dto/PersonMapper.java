package ru.sunrise.phonebook.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.sunrise.phonebook.models.Address;
import ru.sunrise.phonebook.models.Person;
import ru.sunrise.phonebook.models.Phone;

import java.util.List;
//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Mapper(componentModel = "spring", uses = {AddressMapper.class, PhoneMapper.class,
                                           StreetMapper.class, PhoneTypeMapper.class})
public interface PersonMapper {


    //    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    @Mappings ({
        @Mapping(target = "address", source = "addressDTO"),
        @Mapping(target = "phones", source = "phonesDTO")})
    Person toPerson(PersonDTO personDTO);

    @InheritInverseConfiguration
    @Mappings ({
            @Mapping(target = "addressDTO", source = "address"),
            @Mapping(target = "phonesDTO", source = "phones")})
    PersonDTO toPersonDTO(Person person);

//    @InheritInverseConfiguration
//    @Mapping(target = "addressDTO", source = "address")
//    @Mapping(target = "phonesDTO", source = "phones")
//    @Mapping(target = "surname", ignore = true)
//    PersonDTO toPersonDTOWithoutSurname(Person person);

//    @InheritInverseConfiguration
//    @Mapping(target = "id", source = "id")
//    @Mapping(source = "city", target = "city")
//    @Mapping(target = "buildingNumber", source = "buildingNumber")
//    @Mapping(target = "ownerId", source = "owner.id")
//    @Mapping(target = "streetId", source = "street.id")
//    AddressDTO toAddressDTO(Address source);
//
//    @InheritInverseConfiguration
//    @Mapping(target = "id", source = "id")
//    @Mapping(source = "number", target = "number")
//    @Mapping(target = "phoneTypeId", source = "phoneType.id")
//    @Mapping(target = "ownerId", source = "owner.id")
//    PhoneDTO toPhoneDTO(Phone source);
    List<PhoneDTO> phonesToPhonesDTO(List<Phone> phones);

    @InheritInverseConfiguration
    List<Phone> phonesDTOToPhones(List<PhoneDTO> phonesDTO);

}
