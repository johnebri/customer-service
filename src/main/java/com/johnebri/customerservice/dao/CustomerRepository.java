package com.johnebri.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnebri.customerservice.data.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findCustomerById(Long id);
	
}
