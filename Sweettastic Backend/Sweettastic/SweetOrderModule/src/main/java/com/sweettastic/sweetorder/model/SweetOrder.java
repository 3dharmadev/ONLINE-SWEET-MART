package com.sweettastic.sweetorder.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sweettastic.customer.model.Customer;
import com.sweettastic.product.model.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SweetOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sweetOrderId;
	
	
	
	@ManyToOne
	@NotNull
	private Customer customer;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "sweetOrderId")
	private List<Product>  products=new ArrayList<>();
	
	@NotNull
	private LocalDate date;

	public Integer getSweetOrderId() {
		return sweetOrderId;
	}

	public void setSweetOrderId(Integer sweetOrderId) {
		this.sweetOrderId = sweetOrderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SweetOrder [sweetOrderId=" + sweetOrderId + ", customer=" + customer + ", products=" + products
				+ ", date=" + date + "]";
	}
	
	
	
	
}
