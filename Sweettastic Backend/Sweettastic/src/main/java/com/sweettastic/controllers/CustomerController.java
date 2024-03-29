package com.sweettastic.controllers;

import java.util.List;

import com.sweettastic.exceptions.CustomerException;
import com.sweettastic.models.Customer;
import com.sweettastic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomerDetailsById(@Valid @RequestBody Customer customer,@PathVariable("id") Integer id) throws CustomerException{
		
		return new ResponseEntity<>(customerService.updateCustomer(customer, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer id) throws CustomerException{
		
		return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerException{
		return new ResponseEntity<>(customerService.showAllCustomers(),HttpStatus.FOUND);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> showAllCustomerDetails(@PathVariable("id") Integer id) throws CustomerException{
		return new ResponseEntity<>(customerService.showCustomerDetailsById(id),HttpStatus.FOUND);
	}
	
	
	
}
