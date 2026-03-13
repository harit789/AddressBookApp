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
		Contact contact = new Contact(contactDTO.getFirstName(), contactDTO.getLastName(), contactDTO.getAddress(),
				contactDTO.getCity(), contactDTO.getState(), contactDTO.getZip(), contactDTO.getPhoneNumber(),
				contactDTO.getEmail());
		contactList.add(contact);
		return contact;
	}

	public List<Contact> getContacts() {
		return contactList;
	}

	public void editContact(String name, ContactDTO dto) {

		for (Contact contact : contactList) {

			if (contact.getFirstName().equalsIgnoreCase(name)) {

				contact.setLastName(dto.getLastName());
				contact.setAddress(dto.getAddress());
				contact.setCity(dto.getCity());
				contact.setState(dto.getState());
				contact.setZip(dto.getZip());
				contact.setPhoneNumber(dto.getPhoneNumber());
				contact.setEmail(dto.getEmail());

				System.out.println("Contact Updated Successfully");
				return;
			}
		}

		System.out.println("Contact Not Found");

	}

	public void displayContacts() {
		contactList.forEach(System.out::println);
	}
}
