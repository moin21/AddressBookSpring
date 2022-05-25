package com.example.addressbookspring.controller;

import com.example.addressbookspring.dto.AddressBookDTO;
import com.example.addressbookspring.dto.ResponseDTO;
import com.example.addressbookspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * RestController Class - AddressBookController
 * Base URL - localhost:8080/address-book
 */
@RequestMapping("/address-book")
@RestController
public class AddressBookController {
    /**
     * Autowired IAddressService - iAddressBookService
     */
    @Autowired
    IAddressBookService iAddressBookService;

    /**
     * Post mapping request method to create contact.
     * Created responseDTO object with message and addContact method applied on iAddressBookService.
     *
     * @param addressBookDTO - addressBookDTO - Constiting all field values
     * @return - Response entity consisting responseDTO and Status Code.
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createContact(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Contact Created Successfully", iAddressBookService.addContact(addressBookDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseDTO> getAllContacts() {
        ResponseDTO responseDTO = new ResponseDTO("Contact List Received Successfully", iAddressBookService.getAllContacts());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ResponseDTO> getByID(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Received Successfully", iAddressBookService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Contact Deleted Successfully", iAddressBookService.deleteById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> editAddress(@Valid @RequestBody AddressBookDTO employeeDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated Successfully", iAddressBookService.editContact(employeeDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
