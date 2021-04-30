package com.johnebri.customerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.johnebri.customerservice.dao.CustomerRepository;
import com.johnebri.customerservice.data.Customer;
import com.johnebri.customerservice.service.CustomerServiceImpl;

@SpringBootTest
class CustomerserviceApplicationTests {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@Test
	public void storeCustomerTest() {
		Customer customer = new Customer();
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.storeCustomer(customer));
	}
	
	@Test
	public void getACustomerTest() {
		Long customerId = 1L;
		Customer newCustomer = new Customer();
		when(customerRepository.findCustomerById(customerId)).thenReturn(newCustomer);
		assertEquals(newCustomer, customerService.getACustomer(customerId));
	}
	
	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(), new Customer()).collect(Collectors.toList()));
		assertEquals(2, customerService.getAllCustomers().size());
	}

}
