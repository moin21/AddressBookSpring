package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.entity.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    AddressBook addContact(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllContacts();
    Optional<AddressBook> getById(int id);
    String deleteById(int id);
    AddressBook editContact(AddressBookDTO employeeDTO, int id);
}
