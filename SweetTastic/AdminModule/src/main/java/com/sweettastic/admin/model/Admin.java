package com.sweettastic.admin.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	private Integer id;
	private String password;
	private List<Customer> list;
	private List<User> users;
	private List<Product> products;
	private List<Category> categories;
	private List<Cart> carts;
	
	
	
}
