package com.johnebri.customerservice.service;

import java.util.List;

import com.johnebri.customerservice.data.Customer;

public interface CustomerService {
	
	Customer storeCustomer(Customer newCustomer);
	
	Customer getACustomer(Long customerId);
	
	List<Customer> getAllCustomers();

}
