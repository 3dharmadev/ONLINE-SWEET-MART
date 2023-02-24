package com.sweettastic.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.customer.exceptions.CustomerException;
import com.sweettastic.customer.model.Customer;
import com.sweettastic.customer.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		if(customerDao.findByUsername(customer.getUsername())!=null) {
			throw new CustomerException("Username already used");
		}
		
		customer=customerDao.save(customer);
		return customer;
		
	}

	@Override
	public Customer updateCustomer(Customer customer,Long customerId) throws CustomerException {
		
		Optional<Customer> opt=customerDao.findById(customerId);
		Customer existingCustomer=opt.get();
		if(existingCustomer!=null){
			
			existingCustomer.setUsername(customer.getUsername());
			existingCustomer.setSweetOrders(customer.getSweetOrders());
			existingCustomer.setCart(customer.getCart());
			
			return existingCustomer;
			
		}else {
			throw new CustomerException("user with this customerId is not present");
		}
	}

	@Override
	public Customer deleteCustomer(Long customerId) throws CustomerException {
	
		   Optional<Customer> opt=customerDao.findById(customerId);
			
			if(opt.isEmpty()) {
				throw new CustomerException("no Customer found with this id");
			}
			customerDao.delete(opt.get());
			return opt.get();
	}

	@Override
	public List<Customer> showAllCustomers() throws CustomerException {
		
		
		List<Customer> customers=customerDao.findAll();
		if(customers.isEmpty()) {
			throw new CustomerException("no customer present in database");
		}
				
		return customers;
		
	}

	@Override
	public List<Customer> showAllCustomerDetails(Long customerId) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
