package com.example.addressbookspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Contact name Invalid: It should have at least 3 characters starting with Capital letter.")
    private String fullName;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10 digit number.")
    private String mobileNumber;
    @Email(message = "Please enter a valid email.")
    private String email;
    private String city;

    public String getFullName() {
        return fullName;
    }
}