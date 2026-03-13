package com.AddressBook;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.AddressBook.dto.ContactDTO;
import com.AddressBook.service.AddressBookService;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);

		System.out.println("Welcome to the Address Book App");

		AddressBookService addressBookService = context.getBean(AddressBookService.class);

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nAddress Book Menu");
		System.out.println("1. Add Contact");
		System.out.println("2. Edit Contact");
		System.out.println("3. Display Contacts");

		System.out.println("Choose option :");

		int temp = scanner.nextInt();
		scanner.nextLine(); 

		switch (temp) {

		case 1:

			ContactDTO contactDTO = new ContactDTO();

			System.out.println("Enter First Name:");
			contactDTO.setFirstName(scanner.nextLine());

			System.out.println("Enter Last Name:");
			contactDTO.setLastName(scanner.nextLine());

			System.out.println("Enter Address:");
			contactDTO.setAddress(scanner.nextLine());

			System.out.println("Enter City:");
			contactDTO.setCity(scanner.nextLine());

			System.out.println("Enter State:");
			contactDTO.setState(scanner.nextLine());

			System.out.println("Enter Zip:");
			contactDTO.setZip(scanner.nextLine());

			System.out.println("Enter Phone Number:");
			contactDTO.setPhoneNumber(scanner.nextLine());

			System.out.println("Enter Email:");
			contactDTO.setEmail(scanner.nextLine());

			addressBookService.addContact(contactDTO);

			System.out.println("Contact Added Successfully");
			break;

		case 2:

			System.out.println("Enter first name to edit:");
			String name = scanner.nextLine();

			ContactDTO updatedDTO = new ContactDTO();

			System.out.println("Enter New Last Name:");
			updatedDTO.setLastName(scanner.nextLine());

			System.out.println("Enter New Address:");
			updatedDTO.setAddress(scanner.nextLine());

			System.out.println("Enter New City:");
			updatedDTO.setCity(scanner.nextLine());

			System.out.println("Enter New State:");
			updatedDTO.setState(scanner.nextLine());

			System.out.println("Enter New Zip:");
			updatedDTO.setZip(scanner.nextLine());

			System.out.println("Enter New Phone:");
			updatedDTO.setPhoneNumber(scanner.nextLine());

			addressBookService.editContact(name, updatedDTO);

			break;

		case 3:

			addressBookService.displayContacts();
			break;

		default:
			System.out.println("Invalid Choice");
		}

	}
}