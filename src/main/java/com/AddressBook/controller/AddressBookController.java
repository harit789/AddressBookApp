package com.AddressBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AddressBook.model.Contact;
import com.AddressBook.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	private AddressBookService addressBookService;
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to the Address Book App!";
	}
	
	@PostMapping("/contact")
	public Contact addContact(@RequestBody Contact contact) {
		return addressBookService.addContact(contact);
	}
	
	@GetMapping("/contacts")
	public List<Contact> getContacts(){
		return addressBookService.getContacts();
	}
}
