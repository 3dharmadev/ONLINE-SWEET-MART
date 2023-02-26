package com.sweettastic.service;


import com.sweettastic.exceptions.CustomerException;
import com.sweettastic.models.Customer;

import java.util.List;

public interface CustomerService {
	
    public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,Integer customerId) throws CustomerException;
	
	public Customer deleteCustomer(Integer userId) throws CustomerException;
	
	public List<Customer> showAllCustomers() throws CustomerException;
	
	public Customer showCustomerDetailsById(Integer userId) throws CustomerException;

}
