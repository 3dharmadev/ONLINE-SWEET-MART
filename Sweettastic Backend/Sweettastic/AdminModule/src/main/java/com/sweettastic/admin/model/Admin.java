package com.sweettastic.admin.model;

import java.util.List;

import com.sweettastic.cart.model.Cart;
import com.sweettastic.category.model.Category;
import com.sweettastic.category.model.Customer;
import com.sweettastic.product.model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NotNull
	@Size(max = 15,min = 8)
	private String password;
	
	private List<Customer> list;
	private List<User> users;
	private List<Product> products;
	private List<Category> categories;
	private List<Cart> carts;
	
	
	
}
