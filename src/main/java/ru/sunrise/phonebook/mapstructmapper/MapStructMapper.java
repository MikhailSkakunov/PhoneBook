package ru.sunrise.phonebook.mapstructmapper;


import org.mapstruct.Mapper;
import ru.sunrise.phonebook.dto.*;
import ru.sunrise.phonebook.models.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    PersonDTO personToPersonDto(Person person);

    PhoneDTO phoneToPhoneDTO(Phone phone);

    AddressDTO addressToAddressDTO(Address address);

    PhoneTypeDTO phoneTypeToPhoneTypeDTO(PhoneType phoneType);

    StreetDTO streetToStreetDTO(Street street);

    List<PhoneDTO>  listPhonesToListPhonesDTO(List<Phone> phones);

    List<AddressDTO> listAddressesToListAddressesDTO(List<Address> addresses);

    List<PersonDTO> personsToListPersonsAllDto(List<Person> people);

    List<PhoneTypeDTO> phoneTypesToListAllDto(List<PhoneType> phoneTypes);

    List<StreetDTO> streetsToListAllDto(List<Street> streets);




    Person personDtoToPerson(PersonDTO personDTO);

    Phone phoneDtoToPhone(PhoneDTO phoneDTO);

    Address addressDtoToAddress(AddressDTO addressDTO);

    PhoneType phoneTypeDtoToPhoneType(PhoneTypeDTO phoneTypeDTO);

    Street streetDtoToStreet(StreetDTO streetDTO);

    List<Phone> listPhonesDtoToListPhones(List<PhoneDTO> phonesDTO);

    List<Address> listAddressesDtoToListAddresses(List<AddressDTO> addressesDTO);

    List<Person> personsDtoToListPersonsAll(List<PersonDTO> peopleDTO);

    List<PhoneType> phoneTypesDtoToListAll(List<PhoneTypeDTO> phoneTypesDTO);

    List<Street> streetsDtoToListAll(List<StreetDTO> streetsDTO);
}
