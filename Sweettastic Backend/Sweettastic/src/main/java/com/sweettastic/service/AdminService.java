package com.sweettastic.service;



import com.sweettastic.exceptions.CategoryException;
import com.sweettastic.exceptions.CustomerException;
import com.sweettastic.exceptions.ProductException;
import com.sweettastic.exceptions.UserException;
import com.sweettastic.models.Category;
import com.sweettastic.models.Customer;
import com.sweettastic.models.Product;
import com.sweettastic.models.User;

import java.util.List;

public interface AdminService {
	
	List<Customer> allCustomers() throws CustomerException;

    List<User> allUsers() throws UserException;


    List<Product> allProducts()throws ProductException;

    List<Category> allCategories() throws CategoryException;




}
