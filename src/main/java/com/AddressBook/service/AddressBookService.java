package com.AddressBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.AddressBook.model.Contact;

@Service
public class AddressBookService {
	private List<Contact> contactList = new ArrayList<>();
	
	public Contact addContact(Contact contact) {
		contactList.add(contact);
		return contact;
	}
	
	public List<Contact> getContacts(){
		return contactList;
	}
}
