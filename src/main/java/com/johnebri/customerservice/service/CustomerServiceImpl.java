package com.johnebri.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnebri.customerservice.dao.CustomerRepository;
import com.johnebri.customerservice.data.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer storeCustomer(Customer newCustomer) {
		return customerRepository.save(newCustomer);
	}

	@Override
	public Customer getACustomer(Long customerId) {
		return customerRepository.findCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	

}
