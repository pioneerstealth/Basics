package com.ilp04.utility;
import java.util.List;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImplementation;

public class CustomerUtility {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice =0;
		do{
		System.out.println("Choose the option");
		System.out.println("1.Get All Customer Details \n2.Insert Customer Data\n3.Update Customer\n4.Exit");
		 choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
				case 1:
					getAllCustomers();
					break;
				case 2:
					insertIntoCustomer();
					break;
				case 3:
					updateCustomer();
					break;
				default:
					break;
			}
		}while(choice!=4);
		

		// TODO Auto-generated method stub
		

	}
private static void updateCustomer() {
	CustomerService customerService = new CustomerServiceImplementation();
	int choice =0;
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the Customer Code :");
	int code = scan.nextInt();
	scan.nextLine();
	System.out.println("Enter the Field you want to Update");
	System.out.println("1.First Name \n2.Last Name\n3.address\n4.phonenumber\n5.Aadhar No\n6.Exit");
	choice = scan.nextInt();
	scan.nextLine();
	do{
		
		switch (choice) {
			case 1:
				System.out.println("Enter the First Name :");
				String customerFirstName = scan.nextLine();
				customerService.updateCustomer(code,customerFirstName,"customer_firstname");
				break;
			case 2:
				String customerLastName = scan.nextLine();
				customerService.updateCustomer(code,customerLastName,"customer_lastname");
			case 3:
				String customeraddress = scan.nextLine();
				customerService.updateCustomer(code,customeraddress,"address");
			case 4:
				String customerphoneNumber= scan.nextLine();
				customerService.updateCustomer(code,customerphoneNumber, "phonenumber");
			case 5:
				String customeraadharNumber = scan.nextLine();
				customerService.updateCustomer(code,customeraadharNumber, "aadhar_no");
			case 6:
				break;
			default:
				break;
		}

	}while(choice != 6);


		
	}
private static void insertIntoCustomer() {

		CustomerService customerService = new CustomerServiceImplementation();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Customer  First Name :");
		String firstName = scan.nextLine();
		System.out.println("Enter the Customer  Last Name :");
		String lastName = scan.nextLine();
		System.out.println("Enter the Customer  address :");
		String address = scan.nextLine();
		System.out.println("Enter the Customer  phoneNumber :");
		long phoneNumber = scan.nextLong();
		scan.nextLine();
		System.out.println("Enter the Customer  Aadhar No :");
		long aadharNo = scan.nextLong();
		scan.nextLine();
		Customer customer = new Customer(firstName, lastName, address, phoneNumber,aadharNo);
		int i = customerService.insertIntoCustomer(customer);
		if(i>0){
			System.out.println("Insertion successful "+i+" rows Updated");
		}
		else{
			System.out.println("Insertion Failed");
		}

		
	}

	private static void getAllCustomers() {
		CustomerService customerService = new CustomerServiceImplementation();
		List<Customer> customerList = customerService.getAllCustomers();
		
		System.out.printf("%-15s %-15s %-15s %-30s %-15s %-15s%n", 
		"Customer Code", "First Name", "Last Name", "Address", "Phone Number", "Aadhar No");

	// Print customer details
	for (Customer customer : customerList) {
		System.out.printf("%-15s %-15s %-15s %-30s %-15s %-15s%n", 
			customer.getCustomerCode(), 
			customer.getCustomerFirstname(), 
			customer.getCustomerLastname(), 
			customer.getAddress(), 
			customer.getPhoneNumber(), 
			customer.getAadharNo());
	}
		
		
	}


}
