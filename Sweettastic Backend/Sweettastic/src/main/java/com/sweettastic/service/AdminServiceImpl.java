package com.sweettastic.service;


import com.sweettastic.exceptions.CategoryException;
import com.sweettastic.exceptions.CustomerException;
import com.sweettastic.exceptions.ProductException;
import com.sweettastic.exceptions.UserException;
import com.sweettastic.models.Category;
import com.sweettastic.models.Customer;
import com.sweettastic.models.Product;
import com.sweettastic.models.User;
import com.sweettastic.repositories.CategoryRepo;
import com.sweettastic.repositories.CustomerRepo;
import com.sweettastic.repositories.ProductRepo;
import com.sweettastic.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {



	@Autowired(required = true)
	private CustomerRepo customerDao;


	@Autowired(required = true)
	private UserRepo userRepository;

	@Autowired(required = true)
	private ProductRepo productRepository;

	@Autowired(required = true)
	private CategoryRepo categoryRepository;

	@Override
	public List<Customer> allCustomers() throws CustomerException {
		List<Customer> customers= customerDao.findAll();
		if(customers.isEmpty()) throw  new CustomerException("no customer exists");
		else return customers;
	}

	@Override
	public List<User> allUsers() throws UserException {
		List<User> Users =userRepository.findAll();
		if(Users.isEmpty()) throw  new UserException("no user exists");
		else return Users;
	}

	@Override
	public List<Product> allProducts() throws ProductException {
		List<Product> products=productRepository.findAll();
		if(products.isEmpty()) throw  new ProductException("no product exists");
		else return products;
	}

	@Override
	public List<Category> allCategories() throws CategoryException {
		List<Category> categories=categoryRepository.findAll();
		if(categories.isEmpty()) throw  new CategoryException("no categories exists");
		else return categories;
	}


}
