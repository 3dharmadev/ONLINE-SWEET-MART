package com.sweettastic.customer.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@OneToMany(cascade = CascadeType.ALL)//targetEntity=SweetItem.class
	@JoinColumn(referencedColumnName = "userId")
	private List<SweetItem> SweetItems=new ArrayList<>();
	
	@OneToOne
	private Cart cart;
	
	

}
