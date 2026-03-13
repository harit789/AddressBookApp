package com.AddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AddressBook.dto.ContactDTO;
import com.AddressBook.model.Contact;

@Service
public class AddressBookService {
	private List<Contact> contactList = new ArrayList<>();
	
	public Contact addContact(ContactDTO contactDTO) {
		Contact contact = new Contact(
                contactDTO.getFirstName(),
                contactDTO.getLastName(),
                contactDTO.getAddress(),
                contactDTO.getCity(),
                contactDTO.getState(),
                contactDTO.getZip(),
                contactDTO.getPhoneNumber(),
                contactDTO.getEmail()
        );
		contactList.add(contact);
		return contact;
	}
	
	public List<Contact> getContacts(){
		return contactList;
	}
	
	public void displayContacts() {
		contactList.forEach(System.out::println);
	}
}
