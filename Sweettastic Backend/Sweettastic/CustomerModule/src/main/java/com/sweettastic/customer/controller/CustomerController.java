package com.sweettastic.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweettastic.customer.exceptions.CustomerException;
import com.sweettastic.customer.model.Customer;
import com.sweettastic.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/sweettastic/customer/addCustomer")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("/sweettastic/customer/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomerDetailsById(@Valid @RequestBody Customer customer,@PathVariable("id") Long customerId) throws CustomerException{
		
		return new ResponseEntity<>(customerService.updateCustomer(customer, customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/sweettastic/customer/deleteCustomer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long userId) throws CustomerException{
		
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}
	
	@GetMapping("/sweettastic/customer/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException{
		return new ResponseEntity<>(customerService.showAllCustomers(),HttpStatus.FOUND);
	}
	
	@GetMapping("/sweettastic/customer/getCustomerDetails{id}")
	public ResponseEntity<List<Customer>> showAllCustomerDetails(@PathVariable("id") Long userId) throws CustomerException{
		return new ResponseEntity<>(customerService.showCustomerDetailsById(userId),HttpStatus.FOUND);
	}
	
	
	
}
