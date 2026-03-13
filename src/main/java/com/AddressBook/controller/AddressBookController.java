package com.AddressBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AddressBook.dto.ContactDTO;
import com.AddressBook.model.Contact;
import com.AddressBook.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping("/contact")
    public Contact addContact(@RequestBody ContactDTO contactDTO) {
        return addressBookService.addContact(contactDTO);
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return addressBookService.getContacts();
    }
    
}