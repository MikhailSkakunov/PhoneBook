package ru.sunrise.phonebook.util;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = PeopleNotFoundException.class)
    public String PeopleNotFoundException(Model model) {
        model.addAttribute("err", "PeopleNotFoundException");
        return "errors/people_not_found_exception";
    }

    @ExceptionHandler(value = StreetNotFoundException.class)
    public String StreetNotFoundException(Model model) {
        model.addAttribute("err", "StreetNotFoundException");
        return "errors/street_not_found_exception";
    }

    @ExceptionHandler(value = StreetAlreadyExistException.class)
    public String StreetAlreadyExistException(Model model) {
        model.addAttribute("err", "StreetAlreadyExistException");
        return "errors/street_already_exist_exception";
    }

    @ExceptionHandler(value = PhoneTypeAlreadyExistException.class)
    public String PhoneTypeAlreadyExistException(Model model) {
        model.addAttribute("err", "PhoneTypeAlreadyExistException");
        return "errors/phone_type_already_exist_exception";
    }


    @ExceptionHandler(value = PhoneTypeNotFoundException.class)
    public String PhoneTypeNotFoundException(Model model) {
        model.addAttribute("err", "PhoneTypeNotFoundException");
        return "errors/phone_type_not_found_exception";
    }

    @ExceptionHandler(value = NameFieldsEmptyException.class)
    public String NameFieldsEmptyException(Model model) {
        model.addAttribute("err", "NameFieldsEmptyException");
        return "errors/name_fieldsEmpty_exception";
    }

    @ExceptionHandler(value = PhoneNumberFieldsEmptyException.class)
    public String PhoneNumberFieldsEmptyException(Model model) {
        model.addAttribute("err", "PhoneNumberFieldsEmptyException");
        return "errors/phone_number_fields_empty_exception";
    }

    @ExceptionHandler(value = PhoneNumberAlreadyExist.class)
    public String PhoneNumberAlreadyExist(Model model) {
        model.addAttribute("err", "PhoneNumberAlreadyExist");
        return "errors/phone_number_already_exist";
    }

    @ExceptionHandler(value = PhoneNumberNotFoundException.class)
    public String PhoneNumberNotFoundException(Model model) {
        model.addAttribute("err", "PhoneNumberNotFoundException");
        return "errors/phone_number_not_found_exception";
    }

    @ExceptionHandler(value = AddressFieldsEmptyException.class)
    public String AddressFieldsEmptyException(Model model) {
        model.addAttribute("err", "AddressFieldsEmptyException");
        return "errors/address_fields_empty_exception";
    }


    @ExceptionHandler(value = Exception.class)
    public String AnyOtherHandler() {
        return "error";
    }
}
