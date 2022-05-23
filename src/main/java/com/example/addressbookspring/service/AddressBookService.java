package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.entity.AddressBook;
import com.example.addressbookspring.exception.CustomException;
import com.example.addressbookspring.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {
    @Autowired
    AddressBookRepository addressBookRepository;
    public AddressBook addContact(AddressBookDTO addressBookDTO){
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }
    public List<AddressBook> getAllContacts() {
        if (addressBookRepository.findAll().isEmpty()) {
            throw new CustomException("No contacts in address book.");
        } else return addressBookRepository.findAll();
    }
    public Optional<AddressBook> getById(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            return addressBookRepository.findById(id);
        } else throw new CustomException("No contact matches with the given ID");
    }
    public String deleteById(int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            addressBookRepository.deleteById(id);
            return "Contact with ID: " + id + " is Deleted Successfully!!";
        } else throw new CustomException("No contact matches with the given ID");
    }
    public AddressBook editContact(AddressBookDTO employeeDTO, int id) {
        if (addressBookRepository.findById(id).isPresent()) {
            AddressBook employee1 = new AddressBook(id, employeeDTO);
            return addressBookRepository.save(employee1);
        } else throw new CustomException("No employee matches with the given ID");
    }
}
