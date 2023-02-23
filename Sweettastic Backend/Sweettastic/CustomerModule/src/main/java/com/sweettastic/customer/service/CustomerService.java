package com.sweettastic.customer.service;

import java.util.List;

import com.sweettastic.customer.exceptions.CustomerException;
import com.sweettastic.customer.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,Long customerId) throws CustomerException;
	
	public Customer deleteCustomer(Long userId) throws CustomerException;
	
	public List<Customer> showAllCustomers() throws CustomerException;
	
	public List<Customer> showAllCustomerDetails(Long userId) throws CustomerException;
	

}
