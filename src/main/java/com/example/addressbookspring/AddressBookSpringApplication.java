package com.example.addressbookspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressBookSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookSpringApplication.class, args);
        log.info("Application Loaded Successfully!!");
    }

}
