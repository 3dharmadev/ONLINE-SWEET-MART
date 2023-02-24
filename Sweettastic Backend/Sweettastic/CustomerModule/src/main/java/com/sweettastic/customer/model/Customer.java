package com.sweettastic.customer.model;
import java.util.*;

import com.sweettastic.Cart.Model.Cart;
import com.sweettastic.sweetorder.model.SweetOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String username;
	@OneToMany(cascade = CascadeType.ALL)//targetEntity=SweetItem.class
	@JoinColumn(referencedColumnName = "userId")
	private Set<SweetOrder> sweetOrders=new HashSet<>();// override equals and hashcode
 
	@OneToOne
	private Cart cart;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<SweetOrder> getSweetOrders() {
		return sweetOrders;
	}

	public void setSweetOrders(Set<SweetOrder> sweetOrders) {
		this.sweetOrders = sweetOrders;
	}
 

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(userId, customer.userId) && Objects.equals(username, customer.username) && Objects.equals(cart, customer.cart);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, username, cart);
	}
}
