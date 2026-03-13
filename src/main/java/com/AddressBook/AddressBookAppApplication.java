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

		ApplicationContext context =
				SpringApplication.run(AddressBookAppApplication.class, args);

		System.out.println("Welcome to the Address Book App");

		AddressBookService addressBookService =
				context.getBean(AddressBookService.class);

		Scanner scanner = new Scanner(System.in);
		String choice;

		do {

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

			System.out.println("Want to add more address [Y/N]:");
			choice = scanner.next();


		} while (choice.equalsIgnoreCase("y"));

		System.out.println(addressBookService.getContacts());

	}
}