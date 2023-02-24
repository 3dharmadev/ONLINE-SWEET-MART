package com.sweettastic.admin.service;

import com.sweettastic.category.exception.CategoryException;
import com.sweettastic.category.model.Category;
import com.sweettastic.customer.exceptions.CustomerException;
import com.sweettastic.customer.model.Customer;
import com.sweettastic.product.exception.ProductException;
import com.sweettastic.product.model.Product;
import com.sweettastic.user.exceptions.UserException;
import com.sweettastic.user.model.User;

import java.util.List;

public interface AdminService {
	
	List<Customer> allCustomers() throws CustomerException;

    List<User> allUsers() throws UserException;


    List<Product> allProducts()throws ProductException;

    List<Category> allCategories() throws CategoryException;




}
