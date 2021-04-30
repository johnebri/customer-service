package com.johnebri.customerservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.johnebri.customerservice.data.Customer;
import com.johnebri.customerservice.service.CustomerServiceImpl;
import com.johnebri.customerservice.service.UtilService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	
	private final CustomerServiceImpl customerService;
	private final UtilService utilService;
	
	@Autowired
	public CustomerController(CustomerServiceImpl customerService, 
			UtilService utilService) {
		
		this.customerService = customerService;
		this.utilService = utilService;
		
	}

	// store a new customer 
	@PostMapping()
	public ResponseEntity<?> newCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult) {	
		try {
			if(bindingResult.hasErrors()) {
				utilService.getResponse(bindingResult);
			}
			customer.getBillingDetail().setAccountNo(utilService.generateAccountNo());
			Customer newCustomer = customerService.storeCustomer(customer);
			return utilService.getResponse("Customer Created Successfully", newCustomer, HttpStatus.CREATED);
		} catch (Exception e) {
			return utilService.getResponse(null, e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	// retrieve a customer 
	@GetMapping("{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable("customerId") Long customerId) {
		
		Customer customer = customerService.getACustomer(customerId);
		if(customer == null) {
			return utilService.getResponse("Customer NOT Found", null, HttpStatus.OK);	
		}
		return utilService.getResponse("Customer Found", customer, HttpStatus.OK);		
	}
	
	// get all customers 
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		
		List<Customer> allCustomers = customerService.getAllCustomers();
		if(allCustomers.isEmpty()) {
			return utilService.getResponse("No Custmer Found", null, HttpStatus.OK);
		}	
		return utilService.getResponse("Customers Found", allCustomers, HttpStatus.OK);
		
	}

}
