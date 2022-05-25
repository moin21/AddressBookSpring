package com.example.addressbookspring.entity;

import com.example.addressbookspring.dto.AddressBookDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String mobileNumber;
    private String email;
    private String city;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.fullName = addressBookDTO.getFullName();
        this.mobileNumber = addressBookDTO.getMobileNumber();
        this.email = addressBookDTO.getEmail();
        this.city = addressBookDTO.getCity();
    }

    public AddressBook(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.fullName = addressBookDTO.getFullName();
        this.mobileNumber = addressBookDTO.getMobileNumber();
        this.email = addressBookDTO.getEmail();
        this.city = addressBookDTO.getCity();
    }
}
