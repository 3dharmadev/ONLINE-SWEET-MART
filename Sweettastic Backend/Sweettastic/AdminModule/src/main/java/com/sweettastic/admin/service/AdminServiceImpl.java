package com.sweettastic.admin.service;

import com.sweettastic.category.exception.CategoryException;
import com.sweettastic.category.model.Category;
import com.sweettastic.category.repository.CategoryRepository;
import com.sweettastic.customer.exceptions.CustomerException;
import com.sweettastic.customer.model.Customer;
import com.sweettastic.customer.repository.CustomerDao;
import com.sweettastic.product.exception.ProductException;
import com.sweettastic.product.model.Product;
import com.sweettastic.user.exceptions.UserException;
import com.sweettastic.user.model.User;

import com.sweettastic.product.repository.ProductRepository;
import com.sweettastic.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.admin.repository.AdminRepo;

import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{

	@Autowired
	private AdminRepo adminDao;

	@Autowired
	private CustomerDao customerDao;


	@Autowired
	private userRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

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
