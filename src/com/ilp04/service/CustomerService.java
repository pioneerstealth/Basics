package com.ilp04.service;

import java.util.List;

import com.ilp04.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public int insertIntoCustomer(Customer customer);
	public int updateCustomer(int code ,String value, String type);
	
}
