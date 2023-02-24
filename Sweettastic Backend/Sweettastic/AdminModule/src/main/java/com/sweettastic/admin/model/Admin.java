package com.sweettastic.admin.model;

import java.util.ArrayList;
import java.util.List;

import com.sweettastic.user.model.User;
import com.sweettastic.Cart.Model.Cart;
import com.sweettastic.category.model.Category;
import com.sweettastic.customer.model.Customer;
import com.sweettastic.product.model.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

	@Id
	private Integer id;
	
	@NotNull
	@Size(max = 15,min = 8)
	private String password;

	@OneToMany
	private List<Customer> customers=new ArrayList<>();

	@OneToMany
	private List<User> Users =new ArrayList<>();

	@OneToMany
	private List<Product> products=new ArrayList<>();

	@OneToMany
	private List<Category> categories=new ArrayList<>();

	@OneToMany
	private List<Cart> carts=new ArrayList<>();
	
	
	
}
